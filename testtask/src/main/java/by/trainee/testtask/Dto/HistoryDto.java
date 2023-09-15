package by.trainee.testtask.Dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class HistoryDto {

    private int id;
    private String user_login;
    private String action;
    private Date date;


}
