package by.trainee.testtask.Controllers;

import by.trainee.testtask.Dto.UserDto;
import by.trainee.testtask.Facade.AllUsersFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class AllUsersController {


    private AllUsersFacade facade;


    @GetMapping("/users")
    public ResponseEntity<?> getUsers( ){
            return new ResponseEntity<>(facade.getAllUsers(), HttpStatus.OK);

    }

    //просто продемострировал как можно получить информацию с любого api
    @GetMapping("/users/plus")
    public ResponseEntity<?> getUsersPlus( ){

    UserDto[] jsons = new UserDto[25];
    RestTemplate restTemplate=new RestTemplate();
    jsons=restTemplate.getForObject("http://localhost:8080/users",jsons.getClass());
    ArrayList<UserDto> JsonArray = (ArrayList<UserDto>) Arrays.stream(jsons).collect(Collectors.toList());

    System.out.println(JsonArray);

    return new ResponseEntity<>(facade.getAllUsers(), HttpStatus.OK);
}

    public AllUsersController(AllUsersFacade facade) {
        this.facade = facade;
    }

}

