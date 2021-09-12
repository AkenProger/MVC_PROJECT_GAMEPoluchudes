package kg.akejan.testPoluchudesProject.dao;

import kg.akejan.testPoluchudesProject.models.entities.GameHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameHistoryRepository extends JpaRepository<GameHistory, Long> {
}
