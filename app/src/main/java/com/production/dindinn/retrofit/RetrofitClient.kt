package com.production.dindinn.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {
    var dinDinnApi: DinDinnApi

    companion object {
        private var ourInstance: Retrofit? = null
        val instance: Retrofit?
            get() {
                if (ourInstance == null) {
                    ourInstance = Retrofit.Builder().baseUrl("https://jsonkeeper.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build()
                }
                return ourInstance
            }
    }

    init {
        val retrofit = instance
        dinDinnApi = retrofit!!.create(DinDinnApi::class.java)
    }
}