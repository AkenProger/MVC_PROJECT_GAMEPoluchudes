package kg.akejan.testPoluchudesProject.mappers;

import kg.akejan.testPoluchudesProject.models.dto.QuestionDto;
import kg.akejan.testPoluchudesProject.models.entities.Questions;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper extends BaseMapper<QuestionDto, Questions> {
    QuestionMapper QUESTION_MAPPER = Mappers.getMapper(QuestionMapper.class);
}
