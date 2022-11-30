package com.example.springbootsecurity.entity;

import lombok.Data;

@Data
public class UserPassword {

    private Integer id;

    private String password;

    private User creator;
}
