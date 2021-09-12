package kg.akejan.testPoluchudesProject.controller;

import kg.akejan.testPoluchudesProject.models.dto.UserDto;
import kg.akejan.testPoluchudesProject.models.entities.Questions;
import kg.akejan.testPoluchudesProject.services.QuestionService;
import kg.akejan.testPoluchudesProject.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorizationController {

    private UserService userService;
    private QuestionService questionService;

    public AuthorizationController(UserService userService, QuestionService questionService) {
        this.userService = userService;
        this.questionService = questionService;
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
                model.addAttribute("questions", questionService.findAll());
                return "admin_page";
            } else {
                model.addAttribute("users", userService.findByLogin(userDto.getLogin()));
                model.addAttribute("randomQuest", questionService.getRandomQuestion());

                System.out.println(questionService.getRandomQuestion().getQuestion());
                return "user_page";
            }
        }
        return "redirect:/index";
    }


}
