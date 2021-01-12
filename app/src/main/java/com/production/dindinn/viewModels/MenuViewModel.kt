package com.production.dindinn.viewModels

import androidx.lifecycle.MutableLiveData
import com.airbnb.mvrx.*
import com.production.dindinn.mvRxDataClass.MenuState;
import com.production.dindinn.application.DinDinnFood
import com.production.dindinn.etc.MenuRepository
import com.production.dindinn.models.MenuModel
import com.production.dindinn.retrofit.DinDinnApi
import io.reactivex.schedulers.Schedulers

class MenuViewModel (
        private val menuState:MenuState,
        private val menuRepository: MenuRepository,
        var dinDinnApi: DinDinnApi
) : BaseMvRxViewModel<MenuState>(menuState, debugMode=true){

    init {

        setState {
            copy(menu = Loading())
        }

       /* menuRepository.getAllMenuItems()
                .execute{
                    copy(menu = it)
                }*/

        dinDinnApi.menu
                ?.subscribeOn(Schedulers.io())
                ?.execute { copy(menu= it as Async<List<MenuModel>>) }
    }

    val errorMessage = MutableLiveData<String>()

    companion object: MvRxViewModelFactory<MenuViewModel, MenuState> {
        override fun create(viewModelContext: ViewModelContext, state: MenuState): MenuViewModel? {
            val menuRepository = viewModelContext.app<DinDinnFood>().menuRepository
            val dinDinnApi=viewModelContext.app<DinDinnFood>().dinDinnApi
            return MenuViewModel(state,menuRepository,dinDinnApi)
        }
    }

}