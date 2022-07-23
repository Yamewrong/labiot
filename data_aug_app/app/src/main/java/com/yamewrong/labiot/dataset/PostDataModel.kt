package com.yamewrong.labiot.dataset

import com.google.gson.annotations.SerializedName
import com.yamewrong.labiot.dataset.M2mDa

data class PostDataModel(
    @SerializedName("m2m:da")
    val data : M2mDa
)