package org.uatransport.service;

import java.util.List;
import org.uatransport.entity.Question;

public interface QuestionService {

  Question save(Question question);

  Question update(Question question);

  void delete(Integer id);

  List<Question> getAll();

  Question getById(Integer id);

  List<Question> getByGroupId(Integer groupId);

  List<Question> getByQuestionName(String questionName);
}
