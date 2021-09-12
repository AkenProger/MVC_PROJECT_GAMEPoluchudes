package kg.akejan.testPoluchudesProject.models.dto;

import kg.akejan.testPoluchudesProject.models.entities.Users;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
public class GameHistoryDto {
    private Long id;
    private Users users;
    private double moneySize;
    private LocalDateTime addDate;
}
