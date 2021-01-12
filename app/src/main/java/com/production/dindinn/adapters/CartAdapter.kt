package com.production.dindinn.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.production.dindinn.R
import com.production.dindinn.models.MenuModel
import com.squareup.picasso.Callback
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

class CartAdapter(private val cartListener: CartListener) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val cart = mutableListOf<MenuModel?>()

    fun setCartItems(cartItems: List<MenuModel?>) {
        this.cart.clear()
        this.cart.addAll(cartItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.CartViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_for_single_cart_item, parent, false)
        return CartViewHolder(view)
    }

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.cart_item_image)
        val name: TextView = itemView.findViewById(R.id.cart_item_name)
        val price: TextView = itemView.findViewById(R.id.cart_item_price)
        val removeFromCart: FloatingActionButton =itemView.findViewById(R.id.cart_item_remove);
    }

    override fun onBindViewHolder(holder: CartAdapter.CartViewHolder, position: Int) {
        val cartItem = cart[position]

        val picasso: Picasso = Picasso.get()
        picasso.isLoggingEnabled = false
        picasso.setIndicatorsEnabled(false)

        if (cartItem != null) {
            picasso.load(cartItem.imageLink).networkPolicy(NetworkPolicy.OFFLINE).into(holder.image, object : Callback {
                override fun onSuccess() {
                }

                override fun onError(e: Exception?) {
                    //  ------------------IF IMAGE IS NOT AVAILABLE OFFLINE YET , DO IT ONLINE -------------
                    val picasso: Picasso = Picasso.get()
                    picasso.isLoggingEnabled = false
                    picasso.setIndicatorsEnabled(false)
                    picasso.load(cartItem.imageLink).into(holder.image)
                }
            })
        }

        if (cartItem != null) {
            holder.name.text = cartItem.name
        }
        if (cartItem != null) {
            holder.price.text = cartItem.price.toString()+" usd"
        }
        holder.removeFromCart.setOnClickListener {
            if (cartItem != null) {
                cartListener.removeItemFromCart(cartItem.id)
            }
        }

    }

    override fun getItemCount() = cart.size

    interface CartListener {
        fun removeItemFromCart(id: Long)
    }

}