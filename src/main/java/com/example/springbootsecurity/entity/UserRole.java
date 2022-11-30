package com.example.springbootsecurity.entity;

import lombok.Data;

@Data
public class UserRole {

    private Integer id;

    private String role;

    private User creator;
}
