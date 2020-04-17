package com.example.chat.service

import com.example.chat.entity.UserBean
import com.example.chat.impl.IUserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @Author Mr.Wu
 * @Date create on 2020/1/11
 * @DES
 */
@Service
class UserService : IUserMapper {
    @Autowired
    private val userMapper: IUserMapper? = null

    override fun login(phone: String?, password: String?): UserBean? = userMapper!!.login(phone, password)

    override fun register(phone: String?, password: String?) = userMapper!!.register(phone, password)

    override fun findUser(phone: String?): UserBean? = userMapper!!.findUser(phone)

}