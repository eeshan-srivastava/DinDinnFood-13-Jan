package com.production.dindinn.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.mvrx.*
import com.production.dindinn.objects.Cart
import com.production.dindinn.objects.Menu
import com.production.dindinn.viewModels.MenuViewModel
import com.production.dindinn.R
import com.production.dindinn.adapters.MenuAdapter
import com.production.dindinn.models.MenuModel
import kotlinx.android.synthetic.main.fragment_menu.*
import java.util.*

class PizzaFragment : BaseMvRxFragment() {

    private val menuViewModel : MenuViewModel by activityViewModel()
    private lateinit var menuAdapter: MenuAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        menuAdapter = MenuAdapter(object : MenuAdapter.CartListener {
            override fun addItemToCart(id: Long) {
                Cart.cart.add(id)
                val counter = activity!!.findViewById<View>(R.id.total_cart_items_counter) as TextView
                if (Cart.cart.size == 0) {
                    counter.visibility = View.GONE
                } else {
                    counter.text = Cart.cart.size.toString()
                    counter.visibility = View.VISIBLE
                }
            }

        })

        menu_filter_layout.visibility=View.VISIBLE

        f_pizza_recycler_view.isNestedScrollingEnabled = false
        f_pizza_recycler_view.setHasFixedSize(true)

        val linearLayoutManager = LinearLayoutManager(activity)
        f_pizza_recycler_view.layoutManager = linearLayoutManager
        f_pizza_recycler_view.adapter = menuAdapter

        menu_filter_spicy.setBackgroundResource(R.drawable.bg_1003)
        menu_filter_spicy.setTextColor(resources.getColor(R.color.Very_Light_Grey))
        menu_filter_vegan.setBackgroundResource(R.drawable.bg_1003)
        menu_filter_vegan.setTextColor(resources.getColor(R.color.Very_Light_Grey))


        menu_filter_vegan.setOnClickListener {
            if (Menu.pizzaFilter == "vegan") {
                Menu.pizzaFilter = "none"
                menu_filter_spicy.setBackgroundResource(R.drawable.bg_1003)
                menu_filter_spicy.setTextColor(resources.getColor(R.color.Very_Light_Grey))
                menu_filter_vegan.setBackgroundResource(R.drawable.bg_1003)
                menu_filter_vegan.setTextColor(resources.getColor(R.color.Very_Light_Grey))

            } else {
                Menu.pizzaFilter = "vegan"
                menu_filter_vegan.setBackgroundResource(R.drawable.bg_1004)
                menu_filter_vegan.setTextColor(resources.getColor(R.color.Grey_5_Light))

                menu_filter_spicy.setBackgroundResource(R.drawable.bg_1003)
                menu_filter_spicy.setTextColor(resources.getColor(R.color.Very_Light_Grey))
            }
            menuAdapter.updateFilter(Menu.pizzaFilter)
            menuAdapter.notifyDataSetChanged()
        }
        menu_filter_spicy.setOnClickListener {
            if (Menu.pizzaFilter == "spicy") {
                Menu.pizzaFilter = "none"
                menu_filter_spicy.setBackgroundResource(R.drawable.bg_1003)
                menu_filter_spicy.setTextColor(resources.getColor(R.color.Very_Light_Grey))
                menu_filter_vegan.setBackgroundResource(R.drawable.bg_1003)
                menu_filter_vegan.setTextColor(resources.getColor(R.color.Very_Light_Grey))

            } else {
                Menu.pizzaFilter = "spicy"
                menu_filter_spicy.setBackgroundResource(R.drawable.bg_1004)
                menu_filter_spicy.setTextColor(resources.getColor(R.color.Grey_5_Light))

                menu_filter_vegan.setBackgroundResource(R.drawable.bg_1003)
                menu_filter_vegan.setTextColor(resources.getColor(R.color.Very_Light_Grey))
            }
            menuAdapter.updateFilter(Menu.pizzaFilter)
            menuAdapter.notifyDataSetChanged()
        }

        menuViewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })

    }



    override fun invalidate() {
        withState(menuViewModel) { state ->
            when (state.menu) {
                is Loading -> {
                    f_pizza_progress_bar.visibility = View.VISIBLE
                    f_pizza_recycler_view.visibility = View.GONE
                }
                is Success -> {
                    f_pizza_progress_bar.visibility = View.GONE
                    f_pizza_recycler_view.visibility = View.VISIBLE
                    Menu.menu = state.menu.invoke() as ArrayList<MenuModel>;
                    val pizzaMenu = state.menu.invoke().filter { it.type == "pizza" }
                    menuAdapter.setMenu(pizzaMenu)
                }
                is Fail -> {
                    Toast.makeText(requireContext(), "Failed to load the menu", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}