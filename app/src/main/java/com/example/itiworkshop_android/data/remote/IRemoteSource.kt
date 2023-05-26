package com.example.itiworkshop_android.data.remote

interface IRemoteSource {
    fun register(email: String, password: String,displayName: String)
    fun login(email: String,password: String)
}