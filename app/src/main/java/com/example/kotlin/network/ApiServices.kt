package com.example.kotlin.network

import com.example.kotlin.models.Employee
import com.example.kotlin.models.EmployeeResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServices {

    @GET("api/v1/employees")
    suspend fun getEmployee():Response<EmployeeResponse>

    companion object {
        operator fun invoke(): ApiServices {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://dummy.restapiexample.com/")
                .build()
                .create(ApiServices::class.java)
        }
    }
}