package by.trainee.testtask.Mapper;

import by.trainee.testtask.Dto.UserDto;
import by.trainee.testtask.Entity.User;

import java.util.ArrayList;

public class MapEntityWithDto {
    public User getUserEntity(UserDto dto)
    {
        if(dto==null){return null;}
        User entity=new User(dto.getLogin(),"Не указан");
        return entity;
    }
    public UserDto getUserDto(User entity)
    { if(entity==null){return null;}
        UserDto dto=new UserDto(entity.getLogin());
        return dto;
    }

    public ArrayList<UserDto> getUserDto(ArrayList<User> entityArray)
    {
        ArrayList<UserDto> dtoArray=new ArrayList<>();
        for(User entity : entityArray){
            dtoArray.add(getUserDto(entity));
        }
        return dtoArray;
    }
}
