package diplom.services;

import diplom.models.Grade;
import diplom.models.Lesson;
import diplom.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GradeService {
    Grade getGradeById(Long gradeId);

    List<Grade> getAllGrades();

    List<Grade> getAllGradesByStudent(Student student);

    List<Grade> getAllGradesByLesson(Lesson lesson);

    List<Grade> getGradesByStudentId(Long studentId);

    void saveGrade(Grade grade);

    void deleteGrade(Long gradeId);

    Grade createGrade(Grade grade);

    Grade updateGrade(Long gradeId, Grade grade);

    List<Grade> getGradesByLessonId(Long lessonId);
}
