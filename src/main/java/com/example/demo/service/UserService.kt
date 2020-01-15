package com.example.demo.service

import com.example.demo.entity.UserBean
import com.example.demo.impl.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @Author Mr.Wu
 * @Date create on 2020/1/11
 * @DES
 */
@Service
class UserService : UserMapper {
    @Autowired
    private val userMapper: UserMapper? = null

    override fun login(phone: String?, password: String?): UserBean? = userMapper!!.login(phone, password)

    override fun register(phone: String?, password: String?) = userMapper!!.register(phone, password)

    override fun findUser(phone: String?): UserBean? = userMapper!!.findUser(phone)

}