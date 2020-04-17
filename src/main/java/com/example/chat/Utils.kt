package com.example.chat

import java.util.regex.Pattern

class Utils {
    class PhoneUtils {

        companion object {
            private const val REGEX_MOBILE = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(16[6])|(17[0,1,3,5-8])|(18[0-9])|(19[8,9]))\\d{8}$"

            fun isMobile(phone: String): Boolean =
                    if (phone.length != 11)
                        false
                    else
                        Pattern.compile(REGEX_MOBILE).matcher(phone).matches()
        }
    }

}