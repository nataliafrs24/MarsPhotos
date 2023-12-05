package com.example.marsphotos

import android.app.Application
import com.example.marsphotos.data.AppContainer
import com.example.marsphotos.data.DefaultAppContainer
/**
 * Aplikasi kelas turunan [Application] yang digunakan untuk inisialisasi dan menyediakan
 * [AppContainer] sebagai wadah (container) untuk dependensi.
 */
class MarsPhotosApplication : Application() {
    /** Instansi AppContainer yang digunakan oleh kelas lain untuk mendapatkan dependensi */
    
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
