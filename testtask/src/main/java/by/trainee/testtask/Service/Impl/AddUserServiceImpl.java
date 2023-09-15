package by.trainee.testtask.Service.Impl;

import by.trainee.testtask.Entity.History;
import by.trainee.testtask.Entity.User;
import by.trainee.testtask.Repository.HistoryRepository;
import by.trainee.testtask.Repository.UserRepository;
import by.trainee.testtask.Service.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.Random;


@org.springframework.stereotype.Service
public class AddUserServiceImpl implements AddUserService {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public HistoryRepository historyRepository;

    @Override
    public boolean addUser(User user) {

       if (userRepository.findByLogin(user.getLogin())==null) {
           userRepository.save(user);
           historyRepository.save(new History(user,"CREATE", new Date(System.currentTimeMillis())));
           return true;
       }else{return false;}

       }



    @Override
    public void justAddUser() {
        User newUser = new User("user1", "пароль рандомного юзера");
        while (!addUser(newUser)) {
            Random random = new Random();
            int number = random.nextInt(1000) + 1;
            String newLogin = "user" + number;
            newUser = new User(newLogin, "пароль рандомного юзера");
        }
    }
}






