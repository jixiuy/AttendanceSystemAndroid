package com.example.attendancesystemandroid.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceCreator {

    private const val BASE_URL ="https://at.kexie.space/api/"

    private val client = OkHttpClient.Builder()
        .connectTimeout(3000, TimeUnit.SECONDS) // 设置连接超时时间为3秒
        .readTimeout(3000, TimeUnit.SECONDS) // 设置读取超时时间为3秒
        .writeTimeout(3000, TimeUnit.SECONDS) // 设置写入超时时间为3秒
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    //inline fun<reified T> create(): T = create(T::class.java)
    //外部调用：val appService = ServiceCreator.create<AppService>()
}
