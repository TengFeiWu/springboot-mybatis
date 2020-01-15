package com.example.demo.controller

import com.example.demo.Utils.PhoneUtils.Companion.isMobile
import com.example.demo.entity.BaseEntity
import com.example.demo.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

/**
 * @Author Mr.Wu
 * @Date create on 2020/1/11
 * @DES
 */
@Api
@RestController
@RequestMapping("/user")
class UserController : BaseController() {

    @Autowired
    private val userService: UserService? = null

    /**
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping(value = ["/login"])
    @ApiOperation(value = "登录")
    @ApiParam()
    private fun login(phone: String, password: String): BaseEntity? {
        return if (isMobile(phone)) {
            val login = userService?.login(phone, password)
            if (login != null)
                postData(data = login)
            else
                postData(code = -1, message = "账号或密码错误")

        } else
            postData(code = -2, message = "请输入正确的手机号")


    }

    /**
     * @param phone
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = ["/register"], method = [RequestMethod.POST])
    @ApiOperation(value = "注册")
    private fun register(phone: String, password: String): BaseEntity? {
        return if (isMobile(phone)) {
            val user = userService?.findUser(phone)
            if (user != null) {
                postData(code = -1, message = "该账号已注册")
            } else {
                userService?.register(phone, password)
                postData(message = "success")

            }
        } else {
            postData(code = -2, message = "请输入正确的手机号")
        }
    }

}