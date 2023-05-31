package com.imagecycle.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imagecycle.model.ImagesApiService
import com.imagecycle.model.ImagesItem
import com.imagecycle.singletons.RetrofitInstance
import kotlinx.coroutines.launch

class ImageViewModel : ViewModel() {

    private val _imagesLiveData = MutableLiveData<List<ImagesItem>>()
    val imagesLiveData: LiveData<List<ImagesItem>> = _imagesLiveData

    private val coursesApiService = RetrofitInstance.getInstance().create(ImagesApiService::class.java)

    fun fetchImages() {
        viewModelScope.launch {
            val courses = coursesApiService.getCourses()
            _imagesLiveData.postValue(courses)
        }
    }
}