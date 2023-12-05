package com.example.marsphotos.network

import com.example.marsphotos.model.MarsPhoto
import retrofit2.http.GET

/**
 * Antarmuka publik yang mengekspos metode [getPhotos]
 */
interface MarsApiService {
    /**
     * Mengembalikan [List] [MarsPhoto] dan metode ini dapat dipanggil dari Coroutine.
     * Anotasi @GET menunjukkan bahwa endpoint "photos" akan diminta dengan metode HTTP GET.
     */
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}
