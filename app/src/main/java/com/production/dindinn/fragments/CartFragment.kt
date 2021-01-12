package com.production.dindinn.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.production.dindinn.objects.Cart
import com.production.dindinn.objects.Menu
import com.production.dindinn.R
import com.production.dindinn.adapters.CartAdapter

import com.production.dindinn.models.MenuModel
import kotlinx.android.synthetic.main.fragment_cart.*


class CartFragment : Fragment() {

    private lateinit var cartAdapter: CartAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val makePayment = activity!!.findViewById<View>(R.id.m_pay) as FloatingActionButton
        makePayment.setOnClickListener {
            if (Cart.cart.isNotEmpty()) {
                Cart.cart.removeAll(Cart.cart)
                cart_recycler_view.visibility = View.GONE
                cart_total_price_layout.visibility = View.GONE
                empty_cart.visibility = View.VISIBLE
                Toast.makeText(requireContext(),"Payment done !", Toast.LENGTH_SHORT).show()
            }
        }

        cartAdapter = CartAdapter(object : CartAdapter.CartListener {
            @SuppressLint("SetTextI18n")
            override fun removeItemFromCart(id: Long) {
                Cart.cart.remove(id)
                if (Cart.cart.isEmpty()) {
                    cart_recycler_view.visibility = View.GONE
                    cart_total_price_layout.visibility = View.GONE
                    empty_cart.visibility = View.VISIBLE
                }else{
                    val cart = mutableListOf<MenuModel?>()
                    var totalPrice:Int=0
                    for (item in Cart.cart) {
                        val menuItem = Menu.menu.filter { it.id == item }
                        val item = menuItem[0];
                        totalPrice += menuItem[0].price
                        total_price_for_cart_items.text = "$totalPrice usd"
                        cart.add(item)
                    }
                    cartAdapter.setCartItems(cart)
                }
            }
        })

        cart_recycler_view.isNestedScrollingEnabled = false
        cart_recycler_view.setHasFixedSize(true)

        val linearLayoutManager = LinearLayoutManager(activity)
        cart_recycler_view.layoutManager = linearLayoutManager
        cart_recycler_view.adapter = cartAdapter

        if (Cart.cart.isEmpty()) {
            cart_recycler_view.visibility = View.GONE
            cart_total_price_layout.visibility = View.GONE
            empty_cart.visibility = View.VISIBLE

        } else {
            empty_cart.visibility = View.GONE
            cart_recycler_view.visibility = View.VISIBLE
            cart_total_price_layout.visibility = View.VISIBLE
            val cart = mutableListOf<MenuModel?>()
            var totalPrice:Int=0
            for (item in Cart.cart) {
                val menuItem = Menu.menu.filter { it.id == item }
                val item = menuItem[0];
                totalPrice += menuItem[0].price
                total_price_for_cart_items.text = "$totalPrice usd"
                cart.add(item)
            }
            cartAdapter.setCartItems(cart)
        }

    }
}