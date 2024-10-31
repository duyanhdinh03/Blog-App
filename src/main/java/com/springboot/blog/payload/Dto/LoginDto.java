package com.springboot.blog.payload.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {


    @NotEmpty(message = "Username or Email is required")
    private String usernameOrEmail;

    @NotEmpty(message = "Password is required")
    private String password;
}
