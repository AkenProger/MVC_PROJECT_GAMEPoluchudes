package kg.akejan.testPoluchudesProject.dao;

import kg.akejan.testPoluchudesProject.models.entities.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Questions, Long> {
}
