package by.trainee.testtask.Security.Jwt.Interfaces;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.function.Function;


public interface JwtTokenUtil {

    public String getUsernameFromToken(String token);

    public Date getExpirationDateFromToken(String token);

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver);

    default Claims getAllClaimsFromToken(String token, String secret) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }


    default Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }


    public String generateToken(UserDetails userDetails);

    public Boolean validateToken(String token, UserDetails userDetails);


}
