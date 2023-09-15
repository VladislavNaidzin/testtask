package by.trainee.testtask.Controllers;

import by.trainee.testtask.Facade.AuthFacade;
import by.trainee.testtask.Dto.Jwt.JwtRequest;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private AuthFacade facade;


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        return ResponseEntity.ok(facade.getJwtResponse(authenticationRequest));
    }



    public AuthController(AuthFacade facade) {
        this.facade = facade;
    }
}
