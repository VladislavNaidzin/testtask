package by.trainee.testtask.Service.Impl;

import by.trainee.testtask.Entity.User;
import by.trainee.testtask.Repository.UserRepository;
import by.trainee.testtask.Service.AllUsersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class AllUsersServiceImpl implements AllUsersService {
    @Autowired
    public UserRepository userRepository;
    @Override
    public ArrayList<User> getAllUsers() {
        return userRepository.findAllUsers();
    }
}
