package kg.akejan.testPoluchudesProject.controller;

import kg.akejan.testPoluchudesProject.models.dto.QuestionDto;
import kg.akejan.testPoluchudesProject.services.AdminService;
import kg.akejan.testPoluchudesProject.services.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    private AdminService adminService;
    private QuestionService questionService;

    public AdminController(AdminService adminService, QuestionService questionService) {
        this.adminService = adminService;
        this.questionService = questionService;
    }

    @GetMapping("/newQuestion")
    public String newQuestion(Model model) {
        model.addAttribute("question", new QuestionDto());
        return "newQuestionPage";
    }

    @PostMapping("/saveQuestion")
    public String saveQuestion(@ModelAttribute("question") QuestionDto questionDto, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newQuestionPage";
        }
        adminService.saveQuestion(questionDto);
        return "redirect:/adminPage";
    }


    @GetMapping("/adminPage")
    public String getQuestions(Model model) {
        model.addAttribute("questions", questionService.findAll());
        return "admin_page";
    }

    @GetMapping("/delete/{id}")
    public String deleteQuestionById(@PathVariable("id") Long id) {
        adminService.deleteQuestionById(id);
        return "redirect:/adminPage";
    }

    @GetMapping("/editQuestion/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("question", questionService.findById(id));
        System.out.println(questionService.findById(id));
        return "updateQuestionPage";
    }


    @PostMapping("/updateQuestion")
    public String updateQuestion(@ModelAttribute("question") QuestionDto questionDto,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateQuestionPage";
        }
        questionService.update(questionDto);
        return "redirect:/adminPage";
    }


}
