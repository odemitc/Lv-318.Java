package org.uatransport.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.uatransport.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

  Optional<Question> findById(Integer id);

  List<Question> findByGroupId(Integer groupId);

  List<Question> findByName(String questionName);
}
