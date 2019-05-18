package com.example.truoratest.UI

import android.app.Application
import com.example.truoratest.DI.AppComponent
import com.example.truoratest.DI.AppModule
import com.example.truoratest.DI.DaggerAppComponent

class App : Application() {

    companion object {
        @JvmStatic
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}