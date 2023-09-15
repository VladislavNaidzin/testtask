package by.trainee.testtask.Facade;

import by.trainee.testtask.Dto.Jwt.JwtRequest;
import by.trainee.testtask.Dto.Jwt.JwtResponse;

public interface AuthFacade {
     JwtResponse getJwtResponse(JwtRequest jwtRequest) throws Exception;
}
