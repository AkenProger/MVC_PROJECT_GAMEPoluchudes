package kg.akejan.testPoluchudesProject.services.impl;

import kg.akejan.testPoluchudesProject.dao.GameHistoryRepository;
import kg.akejan.testPoluchudesProject.mappers.GameHistoryMapper;
import kg.akejan.testPoluchudesProject.models.dto.GameHistoryDto;
import kg.akejan.testPoluchudesProject.services.GameHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameHistoryServiceImpl implements GameHistoryService {
    GameHistoryMapper gameHistoryMapper = GameHistoryMapper.GAME_HISTORY_MAPPER;
    GameHistoryRepository gameHistoryRepository;

    public GameHistoryServiceImpl(GameHistoryRepository gameHistoryRepository) {
        this.gameHistoryRepository = gameHistoryRepository;
    }

    @Override
    public GameHistoryDto save(GameHistoryDto gameHistoryDto) {
        return gameHistoryMapper.toDto(gameHistoryRepository.save(gameHistoryMapper.toEntity(gameHistoryDto)));
    }

    @Override
    public GameHistoryDto update(GameHistoryDto gameHistoryDto) {
        return null;
    }

    @Override
    public List<GameHistoryDto> findAll() {
        return gameHistoryMapper.toDtoList(gameHistoryRepository.findAll());
    }

    @Override
    public GameHistoryDto findById(Long aLong) {
        return null;
    }

    @Override
    public GameHistoryDto deactivate(Long aLong) {
        return null;
    }
}
