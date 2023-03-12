package com.example.termprojectbackend.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    private final String userName;
    private final String password;

    public LoginDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
