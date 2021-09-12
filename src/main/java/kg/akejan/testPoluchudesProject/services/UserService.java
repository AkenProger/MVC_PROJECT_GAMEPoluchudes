package kg.akejan.testPoluchudesProject.services;

import kg.akejan.testPoluchudesProject.models.dto.QuestionDto;
import kg.akejan.testPoluchudesProject.models.dto.UserDto;

public interface UserService extends BaseCrudService<UserDto, Long> {
    boolean checkLoginAndPassword(UserDto userDto);
    UserDto findByLogin(String login);
    boolean findAnswer(String answer);
}
