package com.production.dindinn.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.production.dindinn.fragments.CartFragment

class CartFragmentAdapter(fragmentActivity: FragmentActivity?) : FragmentStateAdapter(fragmentActivity!!) {
    override fun createFragment(position: Int): Fragment {
        if(position==0){
            return CartFragment()
        }else{
            return CartFragment()
        }
    }

    override fun getItemCount(): Int {
        return 1
    }
}