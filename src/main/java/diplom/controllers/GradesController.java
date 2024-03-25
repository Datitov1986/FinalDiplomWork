package diplom.controllers;

import diplom.services.GradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradesController {
    private GradeService gradeService;

    @GetMapping("/grades")
    public String showGradesPage(Model model) {
        GradeService gradeService = null;
        model.addAttribute("grades",gradeService.getAllGrades());
        return "grades";
    }
}
