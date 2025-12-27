package com.codewithmosh.store.entities;

import lombok.Data;

@Data
public class LoginUserRequest {
    private String email;
    private String password;
}
