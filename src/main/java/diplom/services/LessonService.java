package diplom.services;

import diplom.models.Lesson;
import diplom.models.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonService {
    Lesson getLessonById(Long lessonId);

    Lesson createLesson(Lesson lesson);

    Lesson updateLesson(Long lessonId, Lesson lesson);

    List<Lesson> getAllLessons();

    List<Lesson> getLessonsByTeacher(Teacher teacher);

    List<Lesson> getLessonsByTeacherId(Long teacherId);

    void saveLesson(Lesson lesson);

    void deleteLesson(Long lessonId);
}
