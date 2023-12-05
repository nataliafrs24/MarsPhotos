
package com.example.marsphotos.data

import com.example.marsphotos.network.MarsApiService
import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

/**
 * Kontainer Injeksi Dependensi (Dependency Injection) di tingkat aplikasi.
 */
interface AppContainer {
    val marsPhotosRepository: MarsPhotosRepository
}

/**
 * Implementasi  Dependensi di tingkat aplikasi.
 *
 * Variabel diinisialisasi secara  (lazy) dan instansi yang sama dibagikan di  aplikasi.
 */
class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"

    /**
     * Menggunakan Retrofit untuk membuat objek retrofit dengan  menggunakan konverter kotlinx.serialization.
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    /**
     * Menggunakan Objek layanan Retrofit untuk membuat panggilan API.
     */
    private val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

    /**
     * Implementasi untuk repositori foto Mars.
     */
    override val marsPhotosRepository: MarsPhotosRepository by lazy {
        NetworkMarsPhotosRepository(retrofitService)
    }
}
