package by.trainee.testtask.Entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table( name="History")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class History {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(name = "user_login")
        private User user_login;

        private String action;
        private Date date;

        public History(User user_login, String action, Date date) {
                this.user_login = user_login;
                this.action = action;
                this.date = date;
        }
}
