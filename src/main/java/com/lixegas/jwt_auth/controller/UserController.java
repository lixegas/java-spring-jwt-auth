package com.lixegas.jwt_auth.controller;

import com.lixegas.jwt_auth.model.dto.UserRegistrationAndLoginDTO;
import com.lixegas.jwt_auth.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserRegistrationAndLoginDTO registrationUser){
        return userService.registration(registrationUser);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserRegistrationAndLoginDTO loginUser){
        return userService.loginVerification(loginUser);
    }
}
