package com.lixegas.jwt_auth.service;

import com.lixegas.jwt_auth.model.User;
import com.lixegas.jwt_auth.model.dto.UserRegistrationAndLoginDTO;
import com.lixegas.jwt_auth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;
    private AuthenticationManager authenticationManager;
    private JWTService jwtService;

    public String registration(UserRegistrationAndLoginDTO registrationUser){
        User user = new User();

        user.setUsername(registrationUser.getUsername());
        user.setPassword(encoder.encode(registrationUser.getPassword()));

        userRepository.save(user);

        return "New user Created!";
    }


    public String loginVerification(UserRegistrationAndLoginDTO loginUser){
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(loginUser.getUsername());
        }
        return "U are not logged!";
    }
}
