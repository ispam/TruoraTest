package com.example.truoratest.DI

import com.example.truoratest.UI.Home.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, ViewModelModule::class))
interface AppComponent {

    fun inject (activity: MainActivity)
}