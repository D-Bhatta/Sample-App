package com.android.db.sampleapp.data.repository

import com.android.db.sampleapp.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getPictures() = apiHelper.getPictures()
}