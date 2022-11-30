package com.example.springbootsecurity.entity;

import lombok.Data;

@Data
public class UserInfo {

    private Integer id;

    private String phone;

    private String email;

    private String others;

    private Integer roleId;

    private User creator;
}
