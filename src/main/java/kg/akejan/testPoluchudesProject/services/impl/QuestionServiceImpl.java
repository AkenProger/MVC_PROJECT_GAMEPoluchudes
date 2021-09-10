package kg.akejan.testPoluchudesProject.services.impl;

import kg.akejan.testPoluchudesProject.dao.QuestionRepository;
import kg.akejan.testPoluchudesProject.mappers.QuestionMapper;
import kg.akejan.testPoluchudesProject.models.dto.QuestionDto;
import kg.akejan.testPoluchudesProject.models.entities.Questions;
import kg.akejan.testPoluchudesProject.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionMapper questionMapper = QuestionMapper.QUESTION_MAPPER;
    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public QuestionDto save(QuestionDto questionDto) {
        return questionMapper.toDto(questionRepository.save(questionMapper.toEntity(questionDto)));
    }

    @Override
    public QuestionDto update(QuestionDto questionDto) {
        if (!questionRepository.existsById(questionDto.getId()))
            new HttpClientErrorException(HttpStatus.NOT_FOUND, "Вопрос не найден!");
        Questions questions = questionMapper.toEntity(questionDto);
        questions = questionRepository.save(questions);
        return questionMapper.toDto(questions);
    }

    @Override
    public List<QuestionDto> findAll() {
        return questionMapper.toDtoList(questionRepository.findAll());
    }

    @Override
    public QuestionDto findById(Long aLong) {
        return null;
    }

    @Override
    public QuestionDto deactivate(Long aLong) {
        Questions question = questionRepository.findById(aLong).get();
        if (question != null) {
            question.setActive(false);
            questionRepository.save(question);
            return questionMapper.toDto(question);
        }
        return questionMapper.toDto(question);
    }
}
