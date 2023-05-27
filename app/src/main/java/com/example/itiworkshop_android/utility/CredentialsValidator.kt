package com.example.itiworkshop_android.utility


import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.itiworkshop_android.utility.Constant.Companion.PASSWORD_PATTERN
import com.example.itiworkshop_android.utility.Constant.Companion.emailRegex
import java.io.ByteArrayOutputStream

object CredentialsValidator{
    fun isValidEmail(email: String): Boolean {
        return emailRegex.matches(email)
    }

    fun isValidPassword(password: String): Boolean {
        return PASSWORD_PATTERN.matches(password)
    }

    fun getByteArrayFromBitmap(bitmap: Bitmap) : ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        return stream.toByteArray()
    }

    fun getBitmapFromByteArray(array: ByteArray) : Bitmap{
       return BitmapFactory.decodeByteArray(array, 0, array.size)
    }
}