package com.example.termprojectbackend.service;

import org.springframework.stereotype.Service;

import com.example.termprojectbackend.data.entity.User;
import com.example.termprojectbackend.data.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
