package com.example.chat.impl

import com.example.chat.entity.UserBean
import org.apache.ibatis.annotations.Mapper


/**
 * @Author Mr.Wu
 * @Date create on 2020/1/11
 * @DES
 */
@Mapper
interface IUserMapper {
    fun login(phone: String?, password: String?): UserBean?
    fun register(phone: String?, password: String?)
    fun findUser(phone: String?): UserBean?
}