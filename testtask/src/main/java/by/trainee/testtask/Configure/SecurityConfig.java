 package by.trainee.testtask.Configure;



import by.trainee.testtask.Security.Jwt.JwtAuthenticationEntryPoint;
import by.trainee.testtask.Security.Jwt.JwtRequestFilter;
import by.trainee.testtask.Security.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

 @Configuration
 @EnableWebSecurity
 @EnableGlobalMethodSecurity(prePostEnabled = true)
 public class SecurityConfig  extends WebSecurityConfigurerAdapter {



     @Autowired
     private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;



     @Autowired
     private JwtRequestFilter jwtRequestFilter;
    @Autowired
     private UserService userService;
     @Override
     protected void configure(HttpSecurity http) throws Exception {
         http
                .csrf().disable()
                 .authorizeRequests()
                 .antMatchers("/users/add/**").authenticated()
                 .antMatchers("/authenticate").permitAll()
                .antMatchers("registraite/").permitAll()
                 .antMatchers("newUser/").permitAll()
                 .and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS);


         http.addFilterAfter(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);


     }
     @Bean
     public DaoAuthenticationProvider daoAuthenticationProvider(){
         DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
         authenticationProvider.setPasswordEncoder(passwordEncoder());
         authenticationProvider.setUserDetailsService(userService);
         return authenticationProvider;
     }
@Bean
     public PasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();
}



     @Override
     public void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
     }



     @Bean
     @Override
     public AuthenticationManager authenticationManagerBean() throws Exception {
         return super.authenticationManagerBean();
     }






 }