package kg.akejan.testPoluchudesProject.services;

import kg.akejan.testPoluchudesProject.models.dto.QuestionDto;
import kg.akejan.testPoluchudesProject.models.dto.UserDto;

import java.util.List;

public interface AdminService {
    QuestionDto saveQuestion(QuestionDto questionDto);

    QuestionDto updateQuestion(QuestionDto questionDto);

    List<QuestionDto> findAllQuestions();

    void deleteQuestionById(Long id);

    UserDto saveUser(UserDto userDto);

    UserDto update(UserDto userDto);

    List<UserDto> findAll();

    void deleteByUserId(Long id);
}
