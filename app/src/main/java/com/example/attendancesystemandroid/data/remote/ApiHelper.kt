package com.example.attendancesystemandroid.data.remote

class ApiHelper(private val apiService: ApiService) {
    suspend fun getOldUsers() = apiService.getOldTopFiveRecords()
    suspend fun getUsers() = apiService.getTopFiveRecords()


}