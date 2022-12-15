package com.example.termprojectbackend.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.termprojectbackend.data.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

}
