package com.production.dindinn.application

import android.app.Application
import com.production.dindinn.etc.MenuRepository
import com.production.dindinn.retrofit.DinDinnApi
import com.production.dindinn.retrofit.RetrofitClient

class DinDinnFood : Application() {

    val menuRepository = MenuRepository()
    lateinit var dinDinnApi: DinDinnApi

    override fun onCreate() {
        super.onCreate()
        val retrofit = RetrofitClient.instance
        dinDinnApi = retrofit!!.create(DinDinnApi::class.java)
    }
}