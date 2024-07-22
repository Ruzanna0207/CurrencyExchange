package com.manage.converter.core.consts

import com.manage.converter.main_page_screen.keyboard.ButtonNum

object STORAGE {
    const val appId = "_"
    const val base = "USD"

    val image = "https://www.dropbox.com/scl/fi/ookx7fdh4ven91rsc52wv/photo_2024-07-22_20-52-58.jpg?rlkey=y97rxq5mfa0kcu31iyc6srup3&st=x34zl5kw&raw=1"

    val listNumbers = listOf(
        ButtonNum("1", "."),
        ButtonNum("2", "abc"),
        ButtonNum("3", "def"),
        ButtonNum("4", "ghi"),
        ButtonNum("5", "jkl"),
        ButtonNum("6", "mno"),
        ButtonNum("7", "pqrs"),
        ButtonNum("8", "tuv"),
        ButtonNum("9", "wxyz"),
        ButtonNum("0", "-")
    )

    const val EMPTY = ""
    const val INT_ZERO = 0
    const val DOUBLE_ZERO: Double = 0.0
}