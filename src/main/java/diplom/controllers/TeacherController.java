package diplom.controllers;

import diplom.models.Lesson;
import diplom.models.Teacher;
import diplom.services.GradeService;
import diplom.services.LessonService;
import diplom.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private GradeService gradeService;

    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long teacherId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        return ResponseEntity.ok(teacher);
    }

    @PostMapping("/")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher newTeacher = teacherService.createTeacher(teacher);
        return ResponseEntity.created(URI.create("/api/teachers/" + newTeacher.getId())).body(newTeacher);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long teacherId, @RequestBody Teacher teacher) {
        Teacher updatedTeacher = teacherService.updateTeacher(teacherId, teacher);
        return ResponseEntity.ok(updatedTeacher);
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> deletTeacher(@PathVariable Long teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{teacherId}/lessons")
    public ResponseEntity<List<Lesson>> getLessonsByTeacherId(@PathVariable Long teacherId) {
        List<Lesson> lessons = lessonService.getLessonsByTeacherId(teacherId);
        return ResponseEntity.ok(lessons);
    }


}
