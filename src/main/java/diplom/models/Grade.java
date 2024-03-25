package diplom.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "grades")
@Data
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Оценка")
    private int value;
    @Column(name = "Студент")
    private Student student;
    @Column(name = "Урок")
    private Lesson lesson;
}
