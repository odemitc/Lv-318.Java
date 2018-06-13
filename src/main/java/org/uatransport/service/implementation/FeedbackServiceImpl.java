package org.uatransport.service.implementation;

import com.google.common.collect.Streams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uatransport.entity.Feedback;
import org.uatransport.entity.FeedbackCriteria;
import org.uatransport.entity.dto.FeedbackDTO;
import org.uatransport.exception.ResourceNotFoundException;
import org.uatransport.repository.FeedbackRepository;
import org.uatransport.service.FeedbackService;
import org.uatransport.service.model.AccepterFeedback;
import org.uatransport.service.model.CapacityFeedback;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

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


    public List<CapacityFeedback> convertCapacityFeedBacks(Integer transitId) {
        return getByTransitAndFeedbackCriteria(transitId, FeedbackCriteria.FeedbackType.CAPACITY)
                .stream()
                .map(feedback -> (CapacityFeedback) FeedbackCriteria.FeedbackType.CAPACITY.convertFeedback(feedback))
                .collect(Collectors.toList());
    }

    public List<AccepterFeedback> convertAccepterFeedBacks(Integer transitId) {
        return getByTransitAndFeedbackCriteria(transitId, FeedbackCriteria.FeedbackType.ACCEPTER)
                .stream()
                .map(feedback -> (AccepterFeedback) FeedbackCriteria.FeedbackType.ACCEPTER.convertFeedback(feedback))
                .collect(Collectors.toList());
    }

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

    private Double getCapacityByTransitAndHour(Integer transitId, Integer time) {
        return convertCapacityFeedBacks(transitId).stream()
                .filter(capacityFeedback -> capacityFeedback.startHour!=null)
                .filter(capacityFeedback -> capacityFeedback.endHour!=null)
                .filter(capacityFeedback -> capacityFeedback.existsInTimeRange(time))
                .filter(capacityFeedback -> capacityFeedback.capacity != null)
                .mapToInt(CapacityFeedback::getCapacity)
                .average()
                .orElse(0.0);
    }

    public Map<Integer, Double> getCapacityMap(Integer transitId) {
        Map<Integer, Double> capacityMap = new TreeMap<>();
        for (int hour = 0; hour < 24; hour++) {
            capacityMap.put(hour, getCapacityByTransitAndHour(transitId, hour));
        }
        return capacityMap;
    }


}