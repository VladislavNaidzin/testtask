package by.trainee.testtask.Controllers;


import by.trainee.testtask.Dto.UserDto;
import by.trainee.testtask.Facade.IdUserFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IdUserController {


    private IdUserFacade facade;



    @GetMapping("/users/{login}")
    public ResponseEntity<?> getUsers(@PathVariable(name="login") String login){
        UserDto response=facade.getUser(login);
            return response != null
                    ? new ResponseEntity<>(response, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }


    public IdUserController(IdUserFacade facade) {
        this.facade = facade;
    }
}

