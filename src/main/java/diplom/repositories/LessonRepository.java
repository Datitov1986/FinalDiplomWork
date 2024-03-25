package diplom.repositories;

import diplom.models.Lesson;
import diplom.models.Teacher;
import diplom.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByTeacher(Teacher teacher);
}
