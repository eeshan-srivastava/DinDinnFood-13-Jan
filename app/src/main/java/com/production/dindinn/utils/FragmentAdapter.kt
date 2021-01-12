package com.production.dindinn.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.production.dindinn.fragments.DrinksFragment
import com.production.dindinn.fragments.PizzaFragment
import com.production.dindinn.fragments.SushiFragment

class FragmentAdapter(fragmentActivity: FragmentActivity?) : FragmentStateAdapter(fragmentActivity!!) {
    override fun createFragment(position: Int): Fragment {
        if(position==0){
            return PizzaFragment()
        }else if(position==1){
            return SushiFragment()
        }else if(position==2){
            return DrinksFragment()
        }else{
            return PizzaFragment()
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}