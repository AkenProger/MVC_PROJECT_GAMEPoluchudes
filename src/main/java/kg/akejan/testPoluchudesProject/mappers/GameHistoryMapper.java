package kg.akejan.testPoluchudesProject.mappers;

import kg.akejan.testPoluchudesProject.models.dto.GameHistoryDto;
import kg.akejan.testPoluchudesProject.models.entities.GameHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameHistoryMapper extends BaseMapper<GameHistoryDto, GameHistory> {
    GameHistoryMapper GAME_HISTORY_MAPPER = Mappers.getMapper(GameHistoryMapper.class);
}
