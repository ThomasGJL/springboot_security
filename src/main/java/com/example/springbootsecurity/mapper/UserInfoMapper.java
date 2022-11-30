package com.example.springbootsecurity.mapper;

import com.example.springbootsecurity.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    @Select("select * from user_info where creator_id = #{id}")
    UserInfo findByCreator_Id(Integer id);
}
