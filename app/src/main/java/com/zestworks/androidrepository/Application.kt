package com.zestworks.androidrepository

import android.app.Application
import android.content.Context
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

class Application: Application() {

    private val module: Module = applicationContext {
        viewModel { ListingViewModel(get()) }
        bean { ListingRepository(getSharedPreferences("THANDAM",Context.MODE_PRIVATE)) as Repository }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(module))
    }
}