package com.example.termprojectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.termprojectbackend.data.dto.UserDto;
import com.example.termprojectbackend.data.entity.User;
import com.example.termprojectbackend.service.UserService;

@RestController()
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping(path = "/create")
    public String create(@RequestBody UserDto user) {
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        userService.save(newUser);
        return "Sefa";
    }
}
