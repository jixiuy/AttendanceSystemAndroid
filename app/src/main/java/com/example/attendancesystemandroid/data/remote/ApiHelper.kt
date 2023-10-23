package com.example.attendancesystemandroid.data.remote

class ApiHelper(private val apiService: ApiService) {
    suspend fun getUsers() = apiService.getTopFiveRecords()


}