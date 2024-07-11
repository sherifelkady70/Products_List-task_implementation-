package com.route.products_listtask_implementation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppClass : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}