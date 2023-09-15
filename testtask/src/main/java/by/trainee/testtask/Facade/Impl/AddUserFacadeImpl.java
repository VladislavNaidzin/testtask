package by.trainee.testtask.Facade.Impl;

import by.trainee.testtask.Dto.UserDto;
import by.trainee.testtask.Facade.AddUserFacade;
import by.trainee.testtask.Facade.JustAddUserFacade;
import by.trainee.testtask.Mapper.MapEntityWithDto;
import by.trainee.testtask.Service.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class AddUserFacadeImpl implements AddUserFacade, JustAddUserFacade {
    @Autowired
    public AddUserService addUserService;

    @Override
    public boolean addUser(UserDto user) {
        MapEntityWithDto mapper=new MapEntityWithDto();
       return addUserService.addUser(mapper.getUserEntity(user));
    }

    @Override
    public  void justAddUser() {
         addUserService.justAddUser();
    }



}
