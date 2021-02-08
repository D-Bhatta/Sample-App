package com.android.db.sampleapp.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getPictures() = apiService.getPictures()
}