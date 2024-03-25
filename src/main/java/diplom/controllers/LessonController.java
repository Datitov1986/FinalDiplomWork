package diplom.controllers;

import diplom.models.Lesson;
import diplom.models.Student;
import diplom.models.Teacher;
import diplom.services.LessonService;
import diplom.services.StudentService;
import diplom.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/{lessonId}")
    public ResponseEntity<Lesson> getLesson(@PathVariable Long lessonId) {
        Lesson lesson = lessonService.getLessonById(lessonId);
        return ResponseEntity.ok(lesson);
    }

    @PostMapping("/")
    public ResponseEntity<Lesson> createLesson(@RequestBody Lesson lesson) {
        Lesson newLesson = lessonService.createLesson(lesson);
        return ResponseEntity.created(URI.create("/api/lessons/" + newLesson.getId())).body(newLesson);
    }

    @PutMapping("/{lessonId}")
    public ResponseEntity<Lesson> updateLesson(@PathVariable Long lessonId, @RequestBody Lesson lesson) {
        Lesson updatedLesson = lessonService.updateLesson(lessonId, lesson);
        return ResponseEntity.ok(updatedLesson);
    }

    @DeleteMapping("/{lessonId}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long lessonId) {
        lessonService.deleteLesson(lessonId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{lessonId}/teacher")
    public ResponseEntity<Teacher> getTeacherByLesson(@PathVariable Long lessonId) {
        Teacher teacher = teacherService.getTeacherByLessonId(lessonId);
        return ResponseEntity.ok(teacher);
    }

    @GetMapping("/{lessonId}/students")
    public ResponseEntity<List<Student>> getStudentsByLesson(@PathVariable Long lessonId) {
        List<Student> students = studentService.getStudentsByLessonId(lessonId);
        return ResponseEntity.ok(students);
    }
}
