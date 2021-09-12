package kg.akejan.testPoluchudesProject.dao;

import kg.akejan.testPoluchudesProject.models.entities.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface QuestionRepository extends JpaRepository<Questions, Long> {
    @Query(value = "select * from questions q where q.active = 'true'", nativeQuery = true)
    List<Questions> findAllActiveQuestions();


}
