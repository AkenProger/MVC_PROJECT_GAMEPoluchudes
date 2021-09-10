package kg.akejan.testPoluchudesProject.mappers;

import kg.akejan.testPoluchudesProject.models.dto.UserDto;
import kg.akejan.testPoluchudesProject.models.entities.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper extends BaseMapper<UserDto, Users>{
  UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);
}
