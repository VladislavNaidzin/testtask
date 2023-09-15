package by.trainee.testtask.Security.User;



import by.trainee.testtask.Entity.User;
import by.trainee.testtask.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

   public User findByLogin(String login){
        return userRepository.findById(login).orElse(new User());
    }




    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=findByLogin(s);
        if (user==null){
           throw new UsernameNotFoundException(String.format("User '%s' not found", s));
        }
        return SecurityUser.fromUser(user);
    }




}
