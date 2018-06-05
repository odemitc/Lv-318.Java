package com.example.demo.repository;

import com.example.demo.entity.Feedback;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {

    List<Feedback> findByTransit_Id(Integer id);

    List<Feedback> findByUser_Id(Integer id);

    List<Feedback> findByFeedbackCriteria_Id(Integer id);

}
