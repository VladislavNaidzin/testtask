package by.trainee.testtask.Facade.Impl;

import by.trainee.testtask.Dto.UserDto;
import by.trainee.testtask.Facade.AllUsersFacade;
import by.trainee.testtask.Mapper.MapEntityWithDto;
import by.trainee.testtask.Service.AllUsersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class AllUsersFacadeImpl implements AllUsersFacade {
    @Autowired
    public AllUsersService allUsersService;
    @Override
    public ArrayList<UserDto> getAllUsers() {

        MapEntityWithDto mapper=new MapEntityWithDto();
        return mapper.getUserDto(allUsersService.getAllUsers()) ;
    }
}
