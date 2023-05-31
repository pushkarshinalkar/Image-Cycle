package com.imagecycle.model

import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesApiService {

    @GET("photos")
    suspend fun getCourses(): List<ImagesItem>

}