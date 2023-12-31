package com.example.attendancesystemandroid.data.remote

import com.example.attendancesystemandroid.data.model.UserData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("record/topFive?old-man=true")
    suspend fun getOldTopFiveRecords(): Response<UserData>
    @GET("record/topFive")
    suspend fun getTopFiveRecords(): Response<UserData>


}