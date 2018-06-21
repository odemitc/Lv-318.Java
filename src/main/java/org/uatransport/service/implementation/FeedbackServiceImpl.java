package org.uatransport.service.implementation;

import com.google.common.collect.Range;
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
import org.uatransport.service.FeedbackService;
import org.uatransport.service.StopService;
import org.uatransport.service.converter.model.AccepterFeedback;
import org.uatransport.service.converter.model.CapacityFeedback;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final StopService stopService;

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
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Feedback with id '%s' not found", id)));
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
    public List<Feedback> getByTransitAndFeedbackCriteria(Integer transitId,
            FeedbackCriteria.FeedbackType feedbackType) {
        return feedbackRepository.findByTransitIdAndFeedbackCriteriaType(transitId, feedbackType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> getByTransitAndFeedbackCriteriaAndUserId(Integer transitId,
            FeedbackCriteria.FeedbackType feedbackType, Integer userId) {
        return feedbackRepository.findByTransitIdAndFeedbackCriteriaTypeAndUserId(transitId, feedbackType, userId);
    }

    // RATING Feedback converter
    @Override
    @Transactional(readOnly = true)
    public Double getAverageRateByTransitId(Integer transitId) {
        List<Feedback> feedbackList = getByTransitAndFeedbackCriteria(transitId, FeedbackCriteria.FeedbackType.RATING);
        return getAverageRate(feedbackList);
    }

    @Override
    @Transactional(readOnly = true)
    public Double getAverageRateByTransitAndUser(Integer transitId, Integer userId) {
        List<Feedback> feedbackList = getByTransitAndFeedbackCriteriaAndUserId(transitId,
                FeedbackCriteria.FeedbackType.RATING, userId);
        return getAverageRate(feedbackList);
    }

    private Double getAverageRate(List<Feedback> feedbackList) {
        return feedbackList.stream().mapToInt(FeedbackCriteria.FeedbackType.RATING::convertFeedback).average()
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    @Transactional(readOnly = true)
    public Map<Integer, Double> getHourCapacityMap(Integer transitId) {
        Map<Integer, Double> capacityMap = new TreeMap<>();
        for (int hour = 0; hour < 24; hour++) {
            capacityMap.put(hour, getAverageCapacityByTransitAndHour(transitId, hour));
        }
        return capacityMap;
    }

    private Double getAverageCapacityByTransitAndHour(Integer transitId, Integer feedbackHour) {
        return convertCapacityFeedBacks(transitId).stream().filter(CapacityFeedback::isCapacityHoursFeedback)
                .filter(capacityFeedback -> capacityFeedback.existInTimeRange(feedbackHour))
                .mapToInt(CapacityFeedback::getCapacity).average().orElse(0.0);
    }

    private List<CapacityFeedback> convertCapacityFeedBacks(Integer transitId) {
        return getByTransitAndFeedbackCriteria(transitId, FeedbackCriteria.FeedbackType.CAPACITY).stream()
                .map(feedback -> (CapacityFeedback) FeedbackCriteria.FeedbackType.CAPACITY.convertFeedback(feedback))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Map<Stop, Double> getStopCapacityMap(Integer transitId, Stop... stops) {
        List<Stop> stopList = stops.length > 0 ? Arrays.asList(stops) : stopService.getByTransitId(transitId);
        Map<Stop, Double> capacityMap = new TreeMap<>(Comparator
                .comparingInt(stop -> stopService.getIndexByTransitIdAndStopName(transitId, stop.getStreet())));
        for (Stop stop : stopList) {
            capacityMap.put(stop, getCapacityByTransitAndStops(transitId, stop));
        }
        return capacityMap;
    }

    // CAPACITY_Stop diagrams
    private boolean existInStopIndexesRange(Integer transitId, Stop stop, String fromStop, String toStop) {
        Integer fromStopIndex = stopService.getIndexByTransitIdAndStopName(transitId, fromStop);
        Integer toStopIndex = stopService.getIndexByTransitIdAndStopName(transitId, toStop);
        Integer stopIndex = stopService.getIndexByTransitIdAndStopName(transitId, stop.getStreet());

        return Range.closed(fromStopIndex, toStopIndex).contains(stopIndex);
    }

    private Double getCapacityByTransitAndStops(Integer transitId, Stop stop) {
        Predicate<CapacityFeedback> existInRange = capacityFeedback -> existInStopIndexesRange(transitId, stop,
                capacityFeedback.getFrom(), capacityFeedback.getTo());

        return convertCapacityFeedBacks(transitId).stream().filter(CapacityFeedback::isCapacityStopsFeedback)
                .filter(existInRange).mapToInt(CapacityFeedback::getCapacity).average().orElse(0.0);
    }

    @Override
    @Transactional(readOnly = true)
    public EnumMap<AccepterFeedback, Double> getAccepterAnswerPercentageMap(Integer transitId) {
        EnumMap<AccepterFeedback, Double> accepterMap = new EnumMap<>(AccepterFeedback.class);
        for (AccepterFeedback accepterFeedback : AccepterFeedback.values()) {
            double percentValue = 100 * countByValue(accepterFeedback, transitId)
                    / countAllAccepterFeedBacks(transitId);
            accepterMap.put(accepterFeedback, percentValue);
        }
        return accepterMap;
    }

    private Long countByValue(AccepterFeedback answer, Integer transitId) {
        return convertAccepterFeedBacks(transitId).stream().filter(accepterFeedback -> accepterFeedback == answer)
                .count();
    }

    private List<AccepterFeedback> convertAccepterFeedBacks(Integer transitId) {
        return getByTransitAndFeedbackCriteria(transitId, FeedbackCriteria.FeedbackType.ACCEPTER).stream()
                .map(feedback -> (AccepterFeedback) FeedbackCriteria.FeedbackType.ACCEPTER.convertFeedback(feedback))
                .collect(Collectors.toList());
    }

    private Integer countAllAccepterFeedBacks(Integer transitId) {
        return convertAccepterFeedBacks(transitId).size();
    }
}
