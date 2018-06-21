package org.uatransport.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.uatransport.entity.Question;
import org.uatransport.repository.QuestionRepository;
import org.uatransport.service.QuestionService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Transactional
    public Question save(Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return questionRepository.save(question);
    }

    @Transactional
    public Question update(Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        if (questionRepository.existsById(question.getId())) {
            return questionRepository.saveAndFlush(question);
        }
        return questionRepository.findById(question.getId()).orElseThrow(
                () -> new ResourceNotFoundException(String.format("This Question %s does not found", question))); // getting
        // a
        // warning
        // too
        // many
        // arguments
        // for
        // format
        // string
    }

    @Override
    public void delete(Integer id) {
        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getById(Integer id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Question with id '%s' not found", id)));
    }

    @Override
    public List<Question> getByGroupId(Integer groupId) {
        return questionRepository.findByGroupId(groupId);
    }

    @Override
    public List<Question> getByQuestionName(String questionName) {
        return questionRepository.findByName(questionName);
    }
}
