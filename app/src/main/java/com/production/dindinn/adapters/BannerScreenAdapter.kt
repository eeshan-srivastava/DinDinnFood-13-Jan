package com.production.dindinn.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.production.dindinn.R
import com.production.dindinn.utils.BannerScreenItem

class BannerScreenAdapter(private var context: Context, var bannerScreenItemList: List<BannerScreenItem>) : PagerAdapter() {
    override fun getCount(): Int {
        return bannerScreenItemList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layoutScreen = inflater.inflate(R.layout.layout_for_single_banner, null)
        val imageView = layoutScreen.findViewById<ImageView>(R.id.banner_img)
        imageView.setImageResource(bannerScreenItemList[position].image)
        imageView.visibility = View.VISIBLE
        container.addView(layoutScreen)
        return layoutScreen
    }
}