package com.example.attendancesystemandroid.data.repository

import com.example.attendancesystemandroid.data.remote.ApiHelper

class SortRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}