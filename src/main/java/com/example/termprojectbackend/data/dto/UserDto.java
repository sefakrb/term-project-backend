package com.example.termprojectbackend.data.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private final Long id;
    private final String name;
    private final String surname;
    private final String email;
    private final String gsm;
    private final Date registrationDate;

    public UserDto(Long id, String name, String surname, String email, String gsm, Date registrationDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.gsm = gsm;
        this.registrationDate = registrationDate;
    }
}
