package com.example.chat.controller

import com.example.chat.Utils.PhoneUtils.Companion.isMobile
import com.example.chat.entity.BaseEntity
import com.example.chat.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

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
    @RequestMapping(value = ["/login"], method = [RequestMethod.GET])
    @ApiOperation(value = "登录", httpMethod = "GET")
    @ApiParam()
    private fun login(@RequestParam("手机号") phone: String, @RequestParam("密码") password: String): BaseEntity? {
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
    @ApiOperation(value = "注册", httpMethod = "POST")
    private fun register(@RequestParam("手机号") phone: String, @RequestParam("密码") password: String): BaseEntity? {
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