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

import java.time.Duration;
import java.util.List;
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


    public List<Duration> convertBusyHoursFeedBacks(Integer transitId) {
        return getByTransitAndFeedbackCriteria(transitId, FeedbackCriteria.FeedbackType.BUSY_HOURS)
                .stream()
                .<List<Duration>>map(FeedbackCriteria.FeedbackType.BUSY_HOURS::convertFeedback)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public Double convertRatingFeedBacks(Integer transitId) {
        return getByTransitAndFeedbackCriteria(transitId, FeedbackCriteria.FeedbackType.RATING)
                .stream()
                .mapToInt(FeedbackCriteria.FeedbackType.RATING::convertFeedback)
                .average()
                .orElseThrow(ResourceNotFoundException::new);
    }


}