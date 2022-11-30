package com.example.springbootsecurity.mapper;

import com.example.springbootsecurity.entity.UserPassword;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserPasswordMapper {

    @Select("select * from user_password where creator_id = #{id}")
    UserPassword findByCreator_Id(Integer id);

}
