package com.production.dindinn.activities

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.production.dindinn.R
import com.production.dindinn.utils.CartFragmentAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_misc.*

class Misc : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.Black)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_misc)

        m_back_to_menu.setOnClickListener {
            finish()
        };

        val cartFragmentAdapter = CartFragmentAdapter(this@Misc)
        manage_viewpager2.adapter = cartFragmentAdapter
        manage_viewpager2.offscreenPageLimit = 1

    }


}