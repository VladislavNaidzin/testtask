package by.trainee.testtask.Facade.Impl;

import by.trainee.testtask.Security.Jwt.JwtAccessTokenUtil;
import by.trainee.testtask.Dto.Jwt.JwtRequest;
import by.trainee.testtask.Dto.Jwt.JwtResponse;
import by.trainee.testtask.Facade.AuthFacade;
import by.trainee.testtask.Security.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

@org.springframework.stereotype.Service
public class AuthFacadeImpl implements AuthFacade {

    @Autowired
    public AuthenticationManager authenticationManager;
    @Autowired
    public JwtAccessTokenUtil jwtAccessTokenUtil;
    @Autowired
    public UserService userDetailsService;



    @Override
    public JwtResponse getJwtResponse(JwtRequest jwtRequest) throws Exception {

        String userName=jwtRequest.getUsername();
        String userPassword=jwtRequest.getPassword();

        authenticate(userName,userPassword);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

        return new JwtResponse(jwtAccessTokenUtil.generateToken(userDetails));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {

            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {

            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
