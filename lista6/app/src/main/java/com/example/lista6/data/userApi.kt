package com.example.lista6.data

import retrofit2.Response
import retrofit2.http.GET

interface userApi {

    @GET("api/v2/users?size=20")
    suspend fun getData() : List<user>
}