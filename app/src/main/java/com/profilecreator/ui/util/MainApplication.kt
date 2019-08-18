package com.profilecreator.ui.util

import android.app.Application
import android.content.Context
import com.profilecreator.model.ProfileDetails

class MainApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: MainApplication? = null
        var profileDetails: ProfileDetails = ProfileDetails()

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        // initialize for any

        // Use ApplicationContext.
        // example: SharedPreferences etc...
        val context: Context = applicationContext()
    }
}