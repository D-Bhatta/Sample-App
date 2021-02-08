package com.android.db.sampleapp.data.api

import com.android.db.sampleapp.data.model.Picture
import retrofit2.http.GET

interface ApiService {

    @GET("pictures")
    suspend fun getPictures(): List<Picture>

}