package com.example.chat.controller

import com.example.chat.entity.BaseEntity

/**
 * @Author Mr.Wu
 * @Date create on 2020/1/11
 * @DES
 */
open class BaseController {

    fun postData(data:Any?=null,code:Int=0,message:String="success"): BaseEntity {
        val baseEntity = BaseEntity()
        baseEntity.code=code
        baseEntity.message=message
        baseEntity.data=data
        return baseEntity

    }

}