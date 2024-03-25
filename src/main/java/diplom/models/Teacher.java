package diplom.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Учитель")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Имя")
    private String firstName;
    @Column(name = "Фамилия")
    private String lastName;
    @Column(name = "Отчество")
    private String MiddleName;
    @Column(name = "Преаодаваемые предметы")
    private List<Lesson> lessons;
}
