package com.example.demo.impl

import com.example.demo.entity.UserBean
import org.apache.ibatis.annotations.Mapper


/**
 * @Author Mr.Wu
 * @Date create on 2020/1/11
 * @DES
 */
@Mapper
interface UserMapper {
    fun login(phone: String?, password: String?): UserBean?
    fun register(phone: String?, password: String?)
    fun findUser(phone: String?): UserBean?
}