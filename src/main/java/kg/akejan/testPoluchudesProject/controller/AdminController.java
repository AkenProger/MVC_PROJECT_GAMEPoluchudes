package kg.akejan.testPoluchudesProject.controller;

import kg.akejan.testPoluchudesProject.models.dto.QuestionDto;
import kg.akejan.testPoluchudesProject.services.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/saveQuestion")
    public String saveQuestion(@ModelAttribute("newQuestion") QuestionDto questionDto, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newQuestionPage";
        }
        adminService.saveQuestion(questionDto);
        return "admin_page";
    }

}
