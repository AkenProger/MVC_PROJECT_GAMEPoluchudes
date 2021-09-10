package kg.akejan.testPoluchudesProject.mappers;

import kg.akejan.testPoluchudesProject.models.dto.RoleDto;
import kg.akejan.testPoluchudesProject.models.entities.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper extends  BaseMapper<RoleDto, Roles> {
    RoleMapper ROLE_MAPPER = Mappers.getMapper(RoleMapper.class);
}
