package com.ronak.gopani.model.api

import com.ronak.gopani.model.RResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users?offset=0&limit=10")
    fun getRepo(): Call<RResponse>

}