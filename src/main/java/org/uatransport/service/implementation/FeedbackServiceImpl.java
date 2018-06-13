package org.uatransport.service.implementation;

import com.google.common.collect.Streams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uatransport.entity.Feedback;
import org.uatransport.entity.FeedbackCriteria;
import org.uatransport.entity.Stop;
import org.uatransport.entity.dto.FeedbackDTO;
import org.uatransport.exception.ResourceNotFoundException;
import org.uatransport.repository.FeedbackRepository;
import org.uatransport.repository.StopRepository;
import org.uatransport.service.FeedbackService;
import org.uatransport.service.model.AccepterFeedback;
import org.uatransport.service.model.CapacityFeedback;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final StopRepository stopRepository;

    @Override
    public Feedback addFeedback(FeedbackDTO feedbackDTO) {
        if (feedbackDTO == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return feedbackRepository.save(feedbackDTO.convertToEntity());
    }

    @Override
    public List<Feedback> addAll(List<FeedbackDTO> feedbackDTOList) {
        return Streams.stream(feedbackRepository.saveAll(FeedbackDTO.toEntity(feedbackDTOList)))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Feedback getById(Integer id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Feedback with id '%s' not found", id)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getByTransitId(Integer id) {
        return feedbackRepository.findByTransitId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getByCriteriaId(Integer id) {
        return feedbackRepository.findByFeedbackCriteriaId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getByUserId(Integer id) {
        return feedbackRepository.findByUserId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getByTransitAndFeedbackCriteria(Integer transitId, FeedbackCriteria.FeedbackType feedbackType) {
        return feedbackRepository.findByTransitIdAndFeedbackCriteriaType(transitId, feedbackType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getByTransitAndFeedbackCriteriaAndUserId(Integer transitId, FeedbackCriteria.FeedbackType feedbackType, Integer userId) {
        return feedbackRepository.findByTransitIdAndFeedbackCriteriaTypeAndUserId(transitId, feedbackType, userId);
    }

    //RATING Feedback converter
    public Double convertRatingFeedBacks(Integer transitId) {
        return getByTransitAndFeedbackCriteria(transitId, FeedbackCriteria.FeedbackType.RATING)
                .stream()
                .mapToInt(FeedbackCriteria.FeedbackType.RATING::convertFeedback)
                .average()
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Double convertRatingFeedBacksByUser(Integer transitId, Integer userId) {
        return getByTransitAndFeedbackCriteriaAndUserId(transitId, FeedbackCriteria.FeedbackType.RATING, userId)
                .stream()
                .mapToInt(FeedbackCriteria.FeedbackType.RATING::convertFeedback)
                .average()
                .orElseThrow(ResourceNotFoundException::new);
    }

    //CAPACITY Feedback converter
    public List<CapacityFeedback> convertCapacityFeedBacks(Integer transitId) {
        return getByTransitAndFeedbackCriteria(transitId, FeedbackCriteria.FeedbackType.CAPACITY)
                .stream()
                .map(feedback -> (CapacityFeedback) FeedbackCriteria.FeedbackType.CAPACITY.convertFeedback(feedback))
                .collect(Collectors.toList());
    }

    //CAPACITY_Hours diagrams
    private Double getCapacityByTransitAndHour(Integer transitId, Integer time) {
        return convertCapacityFeedBacks(transitId).stream()
                .filter(CapacityFeedback::isCapacityHoursFeedback)
                .filter(capacityFeedback -> capacityFeedback.existsInTimeRange(time))
                .mapToInt(CapacityFeedback::getCapacity)
                .average()
                .orElse(0.0);
    }

    public Map<Integer, Double> getDataForCapacityHoursDiagram(Integer transitId) {
        Map<Integer, Double> capacityMap = new TreeMap<>();
        for (int hour = 0; hour < 24; hour++) {
            capacityMap.put(hour, getCapacityByTransitAndHour(transitId, hour));
        }
        return capacityMap;
    }

    //CAPACITY_Stop diagrams

    private boolean existsInStopRange(Integer transitId, Stop stop, String from, String to) {
        return IntStream.rangeClosed(stopRepository.findIndexByTransitIdAndStopName(transitId, from),
                stopRepository.findIndexByTransitIdAndStopName(transitId, to))
                .boxed()
                .collect(Collectors.toList())
                .contains(stopRepository.findIndexByTransitIdAndStopName(transitId, stop.getStreet()));
    }

    private Double getCapacityByTransitAndStops(Integer transitId, Stop stop) {
        return convertCapacityFeedBacks(transitId).stream()
                .filter(CapacityFeedback::isCapacityStopsFeedback)
                .filter(capacityFeedback -> existsInStopRange(transitId, stop, capacityFeedback.getFrom(),
                        capacityFeedback.getTo()))
                .mapToInt(CapacityFeedback::getCapacity)
                .average()
                .orElse(0.0);
    }

    public Map<Stop, Double> getDataForCapacityStopDiagram(Integer transitId) {
        Map<Stop, Double> capacityMap = new TreeMap<>(Comparator.comparingInt(stop ->
                stopRepository.findIndexByTransitIdAndStopName(transitId, stop.getStreet())));
        for (Stop stop : stopRepository.findByTransitId(transitId)) {
            capacityMap.put(stop, getCapacityByTransitAndStops(transitId, stop));
        }
        return capacityMap;
    }

    public Map<Stop, Double> getDataForCapacityStopDiagram(List<Stop> stopList, Integer transitId) {
        Map<Stop, Double> capacityMap = new TreeMap<>(Comparator.comparingInt(stop ->
                stopRepository.findIndexByTransitIdAndStopName(transitId, stop.getStreet())));
        for (Stop stop : stopList) {
            capacityMap.put(stop, getCapacityByTransitAndStops(transitId, stop));
        }
        return capacityMap;
    }

    //Accepter Feedback converter
    public List<AccepterFeedback> convertAccepterFeedBacks(Integer transitId) {
        return getByTransitAndFeedbackCriteria(transitId, FeedbackCriteria.FeedbackType.ACCEPTER)
                .stream()
                .map(feedback -> (AccepterFeedback) FeedbackCriteria.FeedbackType.ACCEPTER.convertFeedback(feedback))
                .collect(Collectors.toList());
    }

    //Accepter diagrams
    private Long countByValue(AccepterFeedback value, Integer transitId) {
        return convertAccepterFeedBacks(transitId)
                .stream()
                .filter(accepterFeedback -> accepterFeedback==value)
                .count();
    }

    private Long countAllAccepterFeedBacks(Integer transitId) {
        return (long) convertAccepterFeedBacks(transitId)
                .size();
    }

    public EnumMap<AccepterFeedback, Double> getDataForAccepterDiagram(Integer transitId) {
        EnumMap<AccepterFeedback, Double> accepterMap = new EnumMap<>(AccepterFeedback.class);
        for (AccepterFeedback accepterFeedback : AccepterFeedback.values()) {
            double percentValue = 100 * countByValue(accepterFeedback, transitId) / countAllAccepterFeedBacks(transitId);
            accepterMap.put(accepterFeedback, percentValue);
        }
        return accepterMap;
    }
}