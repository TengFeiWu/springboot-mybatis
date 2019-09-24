package com.example.demo.service;

import com.example.demo.entity.UserBean;
import com.example.demo.impl.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserMapper {

    @Autowired
    UserMapper userMapper;


    @Override
    public UserBean login(String phone, String password) {
        return userMapper.login(phone, password);
    }

    @Override
    public void register(String phone, String password) {
        userMapper.register(phone, password);
    }

    @Override
    public UserBean findUser(String phone) {

        return userMapper.findUser(phone);
    }


}
