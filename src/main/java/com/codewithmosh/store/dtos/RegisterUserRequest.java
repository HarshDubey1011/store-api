package com.codewithmosh.store.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank(message = "Name required")
    @Size(min = 6,max = 25,message = "Name should be of at least 6 characters and cannot be more than 25")
    private String name;
    @NotBlank(message = "Email required")
    @Email
    private String email;
    @NotBlank(message = "Password required")
    @Size(min = 6, max = 25, message = "Minimum 6 and Maximum 25 allowed")
    private String password;
}
