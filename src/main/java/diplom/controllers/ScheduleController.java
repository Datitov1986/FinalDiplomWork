package diplom.controllers;

import diplom.services.LessonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScheduleController {

    @GetMapping("/schedule")
    public String showSchedulePage(Model model) {
        LessonService lessonService = null;
        model.addAttribute("lessons", lessonService.getAllLessons());
        return "schedule";
    }
}
