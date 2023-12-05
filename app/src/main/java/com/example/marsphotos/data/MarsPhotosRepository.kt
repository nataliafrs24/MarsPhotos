package com.example.marsphotos.data

import com.example.marsphotos.model.MarsPhoto
import com.example.marsphotos.network.MarsApiService

/**
 * Repositori yang mengambil daftar foto Mars dari MarsApi.
 */
interface MarsPhotosRepository {
    /** Mengambil daftar MarsPhoto dari MarsApi */
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

/**
 * Implementasi Jaringan Repositori yang mengambil daftar foto Mars dari MarsApi.
 *
 * @param marsApiService Layanan API Mars yang digunakan untuk melakukan panggilan jaringan.
 */
class NetworkMarsPhotosRepository(
    private val marsApiService: MarsApiService
) : MarsPhotosRepository {
    /** Mengambil daftar MarsPhoto dari MarsApi */
    override suspend fun getMarsPhotos(): List<MarsPhoto> = marsApiService.getPhotos()
}
