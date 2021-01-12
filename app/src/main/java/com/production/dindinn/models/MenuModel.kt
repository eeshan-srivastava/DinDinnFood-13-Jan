package com.production.dindinn.models

data class MenuModel(
        val id: Long,
        val name: String,
        val imageLink: String,
        val description: String,
        val type : String,
        val sub_type : String,
        val quantity : String,
        val price : Int
)
