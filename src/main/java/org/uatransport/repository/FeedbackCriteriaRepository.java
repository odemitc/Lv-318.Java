package org.uatransport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.uatransport.entity.FeedbackCriteria;

import java.util.List;
import java.util.Optional;

public interface FeedbackCriteriaRepository extends JpaRepository<FeedbackCriteria, Integer> {

    Optional<FeedbackCriteria> findById(Integer id);

    List<FeedbackCriteria> findByWeight(Integer weight);

    List<FeedbackCriteria> findByQuestionsName(String question);

    List<FeedbackCriteria> findByQuestionsId(Integer questionId);

    List<FeedbackCriteria> findByQuestionsGroupId(Integer groupId);

    List<FeedbackCriteria> findByType(FeedbackCriteria.FeedbackType type);

    @Query(value = "SELECT * FROM feedback_criteria WHERE category_id = ?1", nativeQuery = true)
    List<FeedbackCriteria> findFeedbackCriteriaByNonExtendableCategoryId(Integer categoryId);

}