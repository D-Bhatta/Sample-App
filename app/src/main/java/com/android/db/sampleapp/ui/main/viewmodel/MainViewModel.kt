package com.android.db.sampleapp.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.android.db.sampleapp.data.repository.MainRepository
import com.android.db.sampleapp.utils.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getPictures() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getPictures()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "ERROR: In viewmodel"))
        }
    }
}