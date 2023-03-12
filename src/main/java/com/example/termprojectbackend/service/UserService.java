package com.example.termprojectbackend.service;

import com.example.termprojectbackend.data.dto.LoginDto;
import org.springframework.stereotype.Service;

import com.example.termprojectbackend.data.entity.User;
import com.example.termprojectbackend.data.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) {
        userRepository.save(user);
    }

    public User login(LoginDto user) {
        User loggedUser = userRepository.findUserByUserName(user.getUserName());
        return loggedUser;
    }
}
