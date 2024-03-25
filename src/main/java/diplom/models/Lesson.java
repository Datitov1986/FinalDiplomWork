package diplom.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Урок")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Название предмета")
    private String name;
    @Column(name = "Учитель")
    private Teacher teacher;
    @Column(name = "Список класса")
    private List<Student> students;
}
