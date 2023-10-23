package com.example.attendancesystemandroid.data.model


data class UserData(
    val data: List<User>,
    val code: Int,
    val msg: String
)

data class User(
    val userId: Long,
    val userName: String,
    val userDept: String,
    val userLocation: String,
    val totalTime: String,
    val week: Int
)
