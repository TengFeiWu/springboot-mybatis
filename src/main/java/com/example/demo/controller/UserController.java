package com.example.demo.controller;

import com.example.demo.entity.BaseEntity;
import com.example.demo.entity.UserBean;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    private BaseEntity login(String phone, String password) {
        BaseEntity baseEntity = new BaseEntity();
        UserBean login = userService.login(phone, password);
        if (login != null) {
            baseEntity.setMessage("success");
            baseEntity.setData(login);
        } else {
            baseEntity.setCode(-1);
            baseEntity.setMessage("账号或密码错误");
        }

        return baseEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private BaseEntity register(String phone, String password) {
        BaseEntity baseEntity = new BaseEntity();
        UserBean user = userService.findUser(phone);
        if (user != null) {
            baseEntity.setCode(-1);
            baseEntity.setMessage("该账号已注册");
            return baseEntity;
        }
        userService.register(phone, password);
        baseEntity.setMessage("success");
        baseEntity.setData("注册成功！");
        return baseEntity;
    }
}
