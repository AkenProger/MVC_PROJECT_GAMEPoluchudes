package kg.akejan.testPoluchudesProject.controller;

import kg.akejan.testPoluchudesProject.services.UserService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/answerFinder/{answer}")
    public String findAnswer(@ModelAttribute("answer") String answer, Model model) {
        System.out.println(answer);
        if (userService.findAnswer(answer)) {
            return "FINISH";
        }
        return "redirect:/index";
    }
}
