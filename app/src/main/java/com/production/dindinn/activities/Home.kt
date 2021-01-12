package com.production.dindinn.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.production.dindinn.R
import com.production.dindinn.adapters.BannerScreenAdapter
import com.production.dindinn.objects.Cart
import com.production.dindinn.utils.BannerScreenItem
import com.production.dindinn.utils.FragmentAdapter
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*


class Home : AppCompatActivity() {

    private var isLastPageSwiped = false
    private var counterPageScroll = 0
    var previousPage = 0

    private lateinit var bannerScreenAdapter: BannerScreenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.Black)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val fragmentAdapter = FragmentAdapter(this@Home)
        home_viewpager2.adapter = fragmentAdapter
        home_viewpager2.offscreenPageLimit = 2

        changeLabel(getString(R.string.pizza), getString(R.string.sushi), getString(R.string.drinks))

        home_viewpager2.registerOnPageChangeCallback(object : OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position == 0) {
                    previousPage = position
                    isLastPageSwiped = false
                    changeLabel(getString(R.string.pizza), getString(R.string.sushi), getString(R.string.drinks))
                } else if (position == 1) {
                    previousPage = position
                    changeLabel(getString(R.string.sushi), getString(R.string.drinks), getString(R.string.pizza))
                } else if (position == 2 && previousPage != 0) {
                    previousPage = position
                    changeLabel(getString(R.string.drinks), getString(R.string.pizza), getString(R.string.sushi))
                }
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                if (position == 2 && positionOffset == 0f && !isLastPageSwiped) {
                    if (counterPageScroll != 0) {
                        isLastPageSwiped = true
                        home_viewpager2.setCurrentItem(0, false)
                    }
                    counterPageScroll++
                } else {
                    counterPageScroll = 0
                }
            }
        })


        h_go_to_cart.setOnClickListener {
            val intent = Intent(this@Home, Misc::class.java)
            startActivity(intent)
        }

        // fill list
        val bannerScreenItemList: MutableList<BannerScreenItem> = ArrayList<BannerScreenItem>();
        bannerScreenItemList.add(BannerScreenItem(R.drawable.img_1));
        bannerScreenItemList.add(BannerScreenItem(R.drawable.img_2));
        bannerScreenItemList.add(BannerScreenItem(R.drawable.img_3));

        bannerScreenAdapter = BannerScreenAdapter(this, bannerScreenItemList)
        banner_view_pager.adapter = bannerScreenAdapter

        banner_tab_layout.setupWithViewPager(banner_view_pager, true)

        // for setting untouchable tab
        banner_tab_layout.clearOnTabSelectedListeners()
        for (v in banner_tab_layout.touchables) {
            v.isEnabled = false
        }

    }

    private fun changeLabel(input1: String, input2: String, input3: String) {
        label1!!.text = input1
        label2!!.text = input2
        label3!!.text = input3
    }

    override fun onStart() {
        super.onStart()
        if(Cart.cart.size==0){
            total_cart_items_counter.visibility=View.GONE
        }else{
           total_cart_items_counter.text = Cart.cart.size.toString()
            total_cart_items_counter.visibility=View.VISIBLE
        }
    }

}