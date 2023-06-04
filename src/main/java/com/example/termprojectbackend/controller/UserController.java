package com.example.termprojectbackend.controller;

import com.example.termprojectbackend.data.dto.LoginDto;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import com.example.termprojectbackend.data.dto.UserDto;
import com.example.termprojectbackend.data.entity.User;
import com.example.termprojectbackend.service.UserService;

@RestController()
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping(path = "/register")
    public String register(@RequestBody UserDto user) {
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        userService.register(newUser);
        return "User registered";
    }

    @PostMapping(path = "/login")
    public User login(@RequestBody LoginDto user) {
        User loggedUser = userService.login(user);
        if (loggedUser != null){
            return loggedUser;
        } else {
            return new User();
        }
    }
}
