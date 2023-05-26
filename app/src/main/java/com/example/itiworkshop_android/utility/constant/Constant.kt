package com.example.itiworkshop_android.utility.constant
import kotlin.text.Regex
class Constant {
companion object{
    val emailRegex = Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
    val PASSWORD_PATTERN = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{8,}$")
}
}