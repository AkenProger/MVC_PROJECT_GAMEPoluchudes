package kg.akejan.testPoluchudesProject.services.impl;

import kg.akejan.testPoluchudesProject.dao.UserRepository;
import kg.akejan.testPoluchudesProject.mappers.UserMapper;
import kg.akejan.testPoluchudesProject.models.dto.QuestionDto;
import kg.akejan.testPoluchudesProject.models.dto.UserDto;
import kg.akejan.testPoluchudesProject.models.entities.Users;
import kg.akejan.testPoluchudesProject.services.QuestionService;
import kg.akejan.testPoluchudesProject.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper = UserMapper.USER_MAPPER;
    private UserRepository userRepository;
    private QuestionService questionService;

    public UserServiceImpl(UserRepository userRepository, QuestionService questionService) {
        this.userRepository = userRepository;
        this.questionService = questionService;
    }

    @Override
    public UserDto save(UserDto userDto) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
    }

    @Override
    public UserDto update(UserDto userDto) {
        if (!userRepository.existsById(userDto.getId()))
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Пользовател не найден!");
        Users users = userMapper.toEntity(userDto);
        users = userRepository.save(users);
        return userMapper.toDto(users);
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public UserDto findById(Long aLong) {
        Users users = userRepository.findById(aLong)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Не найден пользовател с таким ID номером!"));
        return userMapper.toDto(users);
    }

    @Override
    public UserDto deactivate(Long aLong) {
        Users users = userRepository.findById(aLong).get();
        if (users != null) {
            users.setActive(false);
            users = userRepository.save(users);
            return userMapper.toDto(users);
        } else {
            new HttpClientErrorException(HttpStatus.NOT_FOUND, "Не удалось удалить");
        }
        return userMapper.toDto(users);
    }

    @Override
    public boolean checkLoginAndPassword(UserDto userDto) {
        System.out.println(userDto.getLogin());
        List<UserDto> userDtoList = findAll();
        for (UserDto item : userDtoList) {
            if (item.getLogin().equals(userDto.getLogin())
                    && item.getPassword().equals(userDto.getPassword()))
                return true;
        }
        return false;
    }

    @Override
    public UserDto findByLogin(String login) {
        return userMapper.toDto(userRepository.finByLogin(login));
    }

    @Override
    public boolean findAnswer(String answer) {
        List<QuestionDto> questionDtoList = questionService.getAllActiveQuestion();
        for (QuestionDto question : questionDtoList) {
            System.out.println(question.getQuestion());
            if (question.getAnswer().equals(answer)) {
                return true;
            }
        }
        return false;
    }
}
