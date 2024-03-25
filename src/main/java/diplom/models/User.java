package diplom.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "Пользователи")
public class User {
    @Column(name = "Имя пользователя")
    private String username;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Пароль")
    private String password;
    @Column(name = "Роль")
    private Role role;
    @Setter
    private boolean teacherConfirmed = false;

}
