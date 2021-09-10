package kg.akejan.testPoluchudesProject.models.dto;

import kg.akejan.testPoluchudesProject.models.entities.Roles;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDto {
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
    private Roles roles;

}
