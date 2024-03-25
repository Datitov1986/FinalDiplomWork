package diplom.controllers;

import diplom.models.Grade;
import diplom.models.Student;
import diplom.services.GradeService;
import diplom.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student newStudent = studentService.createStudent(student);
        return ResponseEntity.created(URI.create("/api/students/" + newStudent.getId())).body(newStudent);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(studentId, student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{studentId}/grades")
    public ResponseEntity<List<Grade>> getGradesByStudentId(@PathVariable Long studentId) {
        List<Grade> grades = gradeService.getGradesByStudentId(studentId);
        return ResponseEntity.ok(grades);
    }
}
