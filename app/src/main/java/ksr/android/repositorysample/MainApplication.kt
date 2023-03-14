package ksr.android.repositorysample

import android.app.Application
import android.content.Context

class MainApplication: Application() {

    companion object {
        lateinit var INSTANCE: MainApplication
        lateinit var applicationCtx: Context
    }

    init {
        INSTANCE = this
    }

    override fun onCreate() {
        super.onCreate()
        applicationCtx = this
    }

}