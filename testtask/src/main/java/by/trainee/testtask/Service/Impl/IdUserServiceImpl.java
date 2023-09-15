package by.trainee.testtask.Service.Impl;

import by.trainee.testtask.Entity.History;
import by.trainee.testtask.Entity.User;
import by.trainee.testtask.Repository.HistoryRepository;
import by.trainee.testtask.Repository.UserRepository;
import by.trainee.testtask.Service.IdUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;


@org.springframework.stereotype.Service
public class IdUserServiceImpl implements IdUserService {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public HistoryRepository historyRepository;

    @Override
    public User getUser(String login) {
        User user=userRepository.findByLogin(login);
        if(user!=null){historyRepository.save(new History(user,"VIEWED", new Date(System.currentTimeMillis())));}
        return user;
    }



}
