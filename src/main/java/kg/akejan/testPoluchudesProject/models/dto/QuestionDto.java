package kg.akejan.testPoluchudesProject.models.dto;

import lombok.Data;

@Data
public class QuestionDto {
    private Long id;
    private String question;
    private String answer;
    private boolean active;
}
