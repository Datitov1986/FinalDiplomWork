package diplom.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Студент")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Имя")
    private String firstName;
    @Column(name = "Фамилия")
    private String lastName;
    @Column(name = "Отчество")
    private String MiddleName;
    @Column(name = "Возраст")
    private int age;
    @Column(name = "Класс")
    private String schoolClassName;
    @Column(name = "Оценки")
    private int grades;
}
