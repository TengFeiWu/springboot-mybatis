package com.example.demo.entity

import javax.persistence.*

/**
 * @author Mr_wu
 */
@Entity
@Table(name = "user")
class UserBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var user_id: Long? = null
    @Column
    var user_name: String? = null
    @Column
    var user_avatar: String? = null
    @Column(nullable = false)
    var user_phone: String? = null
    @Column(nullable = false)
    var user_password: String? = null

}