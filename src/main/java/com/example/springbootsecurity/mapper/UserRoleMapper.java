package com.example.springbootsecurity.mapper;

import com.example.springbootsecurity.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    @Select("select * from user_role where creator_id = #{id} ")
    List<UserRole> findByCreator_Id(Integer id);

}
