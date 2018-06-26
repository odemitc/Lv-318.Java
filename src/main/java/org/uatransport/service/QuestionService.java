package org.uatransport.service;

import org.uatransport.entity.Question;

import java.util.List;

public interface QuestionService {

    Question save(Question question);

    Question update(Question question);

    void delete(Integer id);

    List<Question> getAll();

    Question getById(Integer id);

    List<Question> getByGroupId(Integer groupId);

    List<Question> getByQuestionName(String questionName);

    List<Question> getByFeedbackCriteriaId(Integer feedbackCriteriaId);
}
