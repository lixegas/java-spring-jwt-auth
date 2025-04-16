package com.lixegas.jwt_auth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserRegistrationAndLoginDTO {
    private String username;
    private String password;
}
