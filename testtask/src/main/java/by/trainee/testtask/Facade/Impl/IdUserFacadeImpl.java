package by.trainee.testtask.Facade.Impl;

import by.trainee.testtask.Dto.UserDto;
import by.trainee.testtask.Facade.IdUserFacade;
import by.trainee.testtask.Mapper.MapEntityWithDto;
import by.trainee.testtask.Service.IdUserService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class IdUserFacadeImpl implements IdUserFacade {
    @Autowired
    public IdUserService idUserService;


    @Override
    public UserDto getUser(String login) {
        MapEntityWithDto mapper=new MapEntityWithDto();
        return  mapper.getUserDto( idUserService.getUser(login)) ;
    }
}
