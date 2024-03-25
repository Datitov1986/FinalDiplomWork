package diplom.repositories;

import diplom.models.Grade;
import diplom.models.Lesson;
import diplom.models.Student;
import diplom.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudent(Student student);
    List<Grade> findByLesson(Lesson lesson);
}
