package com.example.demo.impl;

import com.example.demo.entity.UserBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserBean login(String phone, String password);

    void register(String phone, String password);

    UserBean findUser(String phone);

}
