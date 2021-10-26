package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//注解
@Mapper
public interface UserMapper {
    @Select("select *from t_user")
    public List<User> findAll();
}
