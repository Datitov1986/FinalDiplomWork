package diplom.services;

import diplom.models.Grade;
import diplom.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student getStudentById(Long studentId);

    Student createStudent(Student student);

    Student updateStudent(Long studentId, Student student);

    void deleteStudent(Long studentId);

    List<Student> getStudentsByLessonId(Long lessonId);

    List<Grade> getGradesByStudentId(Long studentId);
}
