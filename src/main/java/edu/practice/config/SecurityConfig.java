package edu.practice.config;

import edu.practice.repo.UserRepo;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

@Bean
UserDetailsService uds(UserRepo repo){
 return u -> repo.findByUsername(u)
  .map(x -> User.withUsername(x.getUsername())
    .password(x.getPassword())
    .roles(x.getRole()).build())
  .orElseThrow();
}

@Bean
SecurityFilterChain filter(HttpSecurity http) throws Exception{
 http.csrf(c->c.disable())
   .authorizeHttpRequests(a->a
     .requestMatchers("/actuator/**").permitAll()
     .anyRequest().authenticated())
   .httpBasic();
 return http.build();
}

@Bean
public static NoOpPasswordEncoder encoder(){
 return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
}
}