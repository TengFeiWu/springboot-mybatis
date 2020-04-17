package com.example.chat.entity

import javax.persistence.*

/**
 * @author Mr_wu
 */
@Entity
@Table(name = "user")
class UserBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var user_id: Long = 0
    @Column()
    var user_name: String = ""
    @Column()
    var user_avatar: String = ""
    @Column(length = 20)
    var user_sex: String = ""
    @Column()
    var user_birth: String = ""
    @Column(nullable = false)
    var user_phone: Long = 0
    @Column(nullable = false)
    var user_password: String = ""

}