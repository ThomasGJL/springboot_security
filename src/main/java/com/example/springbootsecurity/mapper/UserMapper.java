package com.example.springbootsecurity.mapper;

import com.example.springbootsecurity.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User findFirstByUsername(String username);
}
