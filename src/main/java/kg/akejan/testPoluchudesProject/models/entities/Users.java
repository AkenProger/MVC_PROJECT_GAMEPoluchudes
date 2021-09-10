package kg.akejan.testPoluchudesProject.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Pattern(regexp = "[а-яА-Я]*" , message = "Введите на кириллице")
    private String name;
    @NotEmpty
    private String login;
    @Size(min = 5)
    @NotEmpty
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String password;
    private boolean active;
    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Roles roles;


}
