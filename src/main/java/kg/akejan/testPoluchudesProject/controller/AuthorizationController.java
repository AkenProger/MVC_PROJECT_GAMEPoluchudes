package kg.akejan.testPoluchudesProject.controller;

import kg.akejan.testPoluchudesProject.models.dto.UserDto;
import kg.akejan.testPoluchudesProject.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorizationController {

    private UserService userService;

    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String sigIn(Model model) {
        model.addAttribute("admin", new UserDto());
        return "authorization";
    }

    @PostMapping("/admin")
    public String adminIn(@ModelAttribute("admin") UserDto userDto, Model model) {
        if (userService.checkLoginAndPassword(userDto)) {
            UserDto userDto1 = userService.findByLogin(userDto.getLogin());
            if (userDto1.getRoles().getName().equals("admin")) {
                model.addAttribute("admin_page", userService.findAll());
                return "admin_page";
            } else {
                model.addAttribute("users", userService.findByLogin(userDto.getLogin()));
                return "user_page";
            }
        }
        return "redirect:/index";
    }


}
