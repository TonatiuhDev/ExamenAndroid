package com.example.pruebatecnica.commons

import com.example.pruebatecnica.di.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent {
    fun inject(app: CoreApplication)
}