package diplom.controllers;

import diplom.models.Grade;
import diplom.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/{gradeId}")
    public ResponseEntity<Grade> getGrade(@PathVariable Long gradeId) {
        Grade grade = gradeService.getGradeById(gradeId);
        return ResponseEntity.ok(grade);
    }

    @PostMapping("/")
    public ResponseEntity<Grade> createGrade(@RequestBody Grade grade) {
        Grade newGrade = gradeService.createGrade(grade);
        return ResponseEntity.created(URI.create("/api/grades/" + newGrade.getId())).body(newGrade);
    }

    @PutMapping("/{gradeId}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long gradeId, @RequestBody Grade grade) {
        Grade updatedGrade = gradeService.updateGrade(gradeId, grade);
        return ResponseEntity.ok(updatedGrade);
    }

    @DeleteMapping("/{gradeId}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long gradeId) {
        gradeService.deleteGrade(gradeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Grade>> getGradesByStudentId(@PathVariable Long studentId) {
        List<Grade> grades = gradeService.getGradesByStudentId(studentId);
        return ResponseEntity.ok(grades);
    }

    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<List<Grade>> getGradesByLessonId(@PathVariable Long lessonId) {
        List<Grade> grades = gradeService.getGradesByLessonId(lessonId);
        return ResponseEntity.ok(grades);
    }
}
