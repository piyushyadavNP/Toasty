package com.example.myapplication.api

import com.example.myapplication.data.totpModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface APIInterface {
         @POST("/generateTotp")
        suspend fun getTotp(@Body model: totpModel): Response<totpModel>

        @POST("/verifyTotp")
        suspend fun verifyOtp(@Body model: totpModel) : Response<totpModel>

}