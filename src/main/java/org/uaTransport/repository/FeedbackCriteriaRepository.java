package org.uaTransport.repository;

import java.util.List;
import java.util.Optional;

import org.uaTransport.entity.FeedbackCriteria;
import org.uaTransport.entity.RatingCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FeedbackCriteriaRepository extends JpaRepository<FeedbackCriteria, Integer> {

    Optional<FeedbackCriteria> findById(Integer id);

    List<FeedbackCriteria> findByGroupId(Integer groupId);

    List<FeedbackCriteria> findByQuestion(String question);

    List<FeedbackCriteria> findByType(FeedbackCriteria.FeedbackType type);

    List<RatingCriteria> findByWeight(Integer weight);

    @Query(value = "SELECT * FROM feedback_criteria WHERE category_id = ?1", nativeQuery = true)
    List<FeedbackCriteria> findFeedbackCriteriaByNonExtendableCategoryId(Integer categoryId);
}