package com.example.demo.repository;

import com.example.demo.entity.FeedbackCriteria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RateRepository extends JpaRepository<FeedbackCriteria, Integer> {

    Optional<FeedbackCriteria> findById(Integer id);
    Optional<FeedbackCriteria> findByValue(Integer value);

    List<FeedbackCriteria> findByIdList(Integer id);
    List<FeedbackCriteria> findByValueList(Integer value);

}
