package by.trainee.testtask.Controllers;


import by.trainee.testtask.Dto.UserDto;
import by.trainee.testtask.Facade.AddUserFacade;
import by.trainee.testtask.Facade.JustAddUserFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AddUserController {


    private AddUserFacade facade;
    private JustAddUserFacade justAddUserFacade;



    @PostMapping(value = "/users/add")
    public ResponseEntity<?> create(@RequestBody UserDto user) {
        boolean isCreate=facade.addUser(user);
        return isCreate
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    //просто чтоб можно было быстро добавить юзера и протестировать
    @PostMapping("/users/justAdd")
    public ResponseEntity<?> justCreate( ){
        justAddUserFacade.justAddUser();
        return new ResponseEntity<>( HttpStatus.CREATED);

    }



    public AddUserController(AddUserFacade facade, JustAddUserFacade justAddUserFacade) {
        this.facade = facade;
        this.justAddUserFacade = justAddUserFacade;
    }
}

