package com.yamewrong.labiot

import com.google.gson.annotations.SerializedName
import org.json.JSONTokener
import java.io.Serializable

data class HTTP_GET_Model(
    @SerializedName("m2m:cin")
    var Cin: cin
):Serializable
data class cin(
    val ct: String,
    val et: String,
    val con: String,
    val cr: String,
    val cs: Int,
    val lt: String,
    val pi: String,
    val ri: String,
    val rn: String,
    val st: Int,
    val ty: Int
):Serializable

data class PostModel(
    var id : String? =null ,
    var pwd : String?=null,
    var nick : String? =null
):Serializable

data class PostResult(
    var result:String? = null
):Serializable