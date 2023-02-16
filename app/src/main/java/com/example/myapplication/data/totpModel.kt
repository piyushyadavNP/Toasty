package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

data class totpModel(
    @SerializedName("secret")
    var secret: String,

    @SerializedName("time")
    var time: String,


)