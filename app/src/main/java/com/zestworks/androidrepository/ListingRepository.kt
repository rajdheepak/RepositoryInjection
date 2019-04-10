package com.zestworks.androidrepository

import android.content.SharedPreferences

class ListingRepository(private val sharedPreferences: SharedPreferences): Repository {

    override fun editSharedPref() {
        val oldCount = sharedPreferences.getInt("COUNT", 0)
        sharedPreferences.edit().putInt("COUNT",oldCount+1).apply()
    }

    override fun resetSharedPref() {
        sharedPreferences.edit().putInt("COUNT",0).apply()
    }

}