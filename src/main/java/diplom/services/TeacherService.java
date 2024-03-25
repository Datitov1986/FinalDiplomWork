package diplom.services;

import diplom.models.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    Teacher getTeacherById(Long teacherId);

    Teacher createTeacher(Teacher teacher);

    Teacher updateTeacher(Long teacherId, Teacher teacher);

    Teacher getTeacherByName(String teacherName);

    List<Teacher> getAllTeachers();

    List<Teacher> getTeachersByLessonsId(Long lessonId);

    void saveTeacher(Teacher teacher);

    void deleteTeacher(Long teacherId);

    Teacher getTeacherByLessonId(Long lessonId);

}
