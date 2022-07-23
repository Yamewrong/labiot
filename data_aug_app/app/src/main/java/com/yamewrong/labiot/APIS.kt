package com.yamewrong.labiot

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
interface APIS {
    @POST("/Mobius/virtualStore/display1")
    @Headers("accept:application/json","content-type:application/json")
    fun post_users(
        @Body jsonparams: PostModel
    ): Call<PostResult>

    @GET("/Mobius/virtualStore/display1/la")


    @Headers("User-Agent:PostmanRuntime/7.29.0",
        "Accept:*/*",
        "Accept-Encoding:gzip,deflate,br",
        "Connection:keep-alive",
        "Content-Type:application/json; charset=utf-8",
        "Accept:application/json",
        "X-M2M-RI:12345",
        "X-M2M-Origin:justin"
    )

    fun get_users(
    ): Call<cin>


    companion object { // static 처럼 공유객체로 사용가능함. 모든 인스턴스가 공유하는 객체로서 동작함.
        private const val BASE_URL = "http:192.168.20.135:7579/"
        fun create(): APIS {

            val gson :Gson =   GsonBuilder().setLenient().create();

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
//                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(APIS::class.java)
        }
    }
}