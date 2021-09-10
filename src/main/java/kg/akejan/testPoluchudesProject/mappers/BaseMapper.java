package kg.akejan.testPoluchudesProject.mappers;

import java.util.List;

public interface BaseMapper<Dto, Entity> {
    Dto toDto(Entity entity);

    Entity toEntity(Dto dto);

    List<Dto> toDtoList(List<Entity> entities);

    List<Entity> toEntityList(List<Dto> dtoList);
}
