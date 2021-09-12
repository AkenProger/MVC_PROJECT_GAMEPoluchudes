package kg.akejan.testPoluchudesProject.services;

import kg.akejan.testPoluchudesProject.models.dto.QuestionDto;
import java.util.List;
public interface QuestionService extends BaseCrudService<QuestionDto, Long>{
     QuestionDto getRandomQuestion();
     List<QuestionDto> getAllActiveQuestion();
}
