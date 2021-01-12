package com.production.dindinn.retrofit

import com.production.dindinn.models.MenuModel
import io.reactivex.Observable
import retrofit2.http.GET

interface DinDinnApi {
    @get:GET("b/8L23")
    val menu: Observable<List<MenuModel?>?>?
}