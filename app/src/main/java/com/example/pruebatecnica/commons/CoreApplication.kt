package com.example.pruebatecnica.commons

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CoreApplication : Application() {
    companion object {
        lateinit var instance: CoreApplication
            private set
    }

    lateinit var appComponent: AppComponent
        private set


    override fun onCreate() {
        super.onCreate()
        instance = this
        initComponent()
    }

    private fun initComponent() {
        appComponent = DaggerAppComponent.builder().build()
        appComponent.inject(this)
    }
}