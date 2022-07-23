package com.yamewrong.labiot

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Network {

    private val BASE_URL = "http:10.0.2.2:7579/"

    fun getMethod(): Call<cin> {
        val gson: Gson = GsonBuilder().setLenient().create();
        val okHttp = OkHttpClient().newBuilder()
            .followRedirects(false)
            .connectTimeout(10L, TimeUnit.SECONDS)
            .readTimeout(30L, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val retrofitInterface = retrofit.create(APIS::class.java)
        return retrofitInterface.get_users()
    }
}