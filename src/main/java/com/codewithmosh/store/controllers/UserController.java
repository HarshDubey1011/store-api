package com.codewithmosh.store.controllers;

import com.codewithmosh.store.dtos.UserDto;
import com.codewithmosh.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping ("/users")
public class UserController {
    private final UserRepository userRepository;


    @GetMapping
    public List<UserDto> getAllUsers() {
        // Here we are mapping the user to the user dto and naming convention we use the pascal naming convention
        return  userRepository.findAll().stream().map(user -> new UserDto(user.getId(),user.getName(),user.getEmail())).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
       var user =  userRepository.findById(id).orElse(null);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        var userDto = new UserDto(user.getId(),user.getName(),user.getEmail());
        return ResponseEntity.ok(userDto);
    }


}
