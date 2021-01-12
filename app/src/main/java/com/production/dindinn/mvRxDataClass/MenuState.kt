package com.production.dindinn.mvRxDataClass

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.production.dindinn.models.MenuModel

data class MenuState(
        val menu:Async<List<MenuModel>> = Uninitialized
):MvRxState{
}
