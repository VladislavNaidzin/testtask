package by.trainee.testtask.Entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name="User")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {


    @Id
    private String login;

    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }


    @OneToMany(mappedBy = "user_login")
    private List<History> usersHistory;





}