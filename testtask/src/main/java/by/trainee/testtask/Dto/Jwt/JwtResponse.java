package by.trainee.testtask.Dto.Jwt;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwtAccessToken;



    public JwtResponse(String jwtAccessToken) {
        this.jwtAccessToken = jwtAccessToken;
    }



    public String getActiveToken() {
        return this.jwtAccessToken;
    }


}