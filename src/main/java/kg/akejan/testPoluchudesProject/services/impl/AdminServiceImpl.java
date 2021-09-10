package kg.akejan.testPoluchudesProject.services.impl;

import kg.akejan.testPoluchudesProject.models.dto.QuestionDto;
import kg.akejan.testPoluchudesProject.models.dto.UserDto;
import kg.akejan.testPoluchudesProject.services.AdminService;
import kg.akejan.testPoluchudesProject.services.QuestionService;
import kg.akejan.testPoluchudesProject.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private QuestionService questionService;
    private UserService userService;

    public AdminServiceImpl(QuestionService questionService, UserService userService) {
        this.questionService = questionService;
        this.userService = userService;
    }

    @Override
    public QuestionDto saveQuestion(QuestionDto questionDto) {
        return questionService.save(questionDto);
    }

    @Override
    public QuestionDto updateQuestion(QuestionDto questionDto) {
        return questionService.update(questionDto);
    }

    @Override
    public List<QuestionDto> findAllQuestions() {
        return questionService.findAll();
    }

    @Override
    public void deleteQuestionById(Long id) {
        questionService.deactivate(id);
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        return userService.save(userDto);
    }

    @Override
    public UserDto update(UserDto userDto) {
        return userService.update(userDto);
    }

    @Override
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @Override
    public void deleteByUserId(Long id) {
        deleteByUserId(id);
    }


}
