package com.production.dindinn.adapters

import android.annotation.SuppressLint
import android.os.Handler
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.production.dindinn.R
import com.production.dindinn.models.MenuModel
import com.squareup.picasso.Callback
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso


class MenuAdapter(private val cartListener: CartListener) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    private val menu = mutableListOf<MenuModel>()
    private var filter:String="none"
    fun setMenu(menu: List<MenuModel>) {
        this.menu.clear()
        this.menu.addAll(menu)
        notifyDataSetChanged()
    }

    fun updateFilter(filter:String){
        this.filter=filter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_for_single_menu_item, parent, false)
        return MenuViewHolder(view)
    }

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card: MaterialCardView=itemView.findViewById(R.id.home_menu_item_card)
        val image: ImageView = itemView.findViewById(R.id.home_menu_item_menu_image)
        val name: TextView = itemView.findViewById(R.id.home_menu_item_menu_name)
        val description: TextView = itemView.findViewById(R.id.home_menu_item_menu_description)
        val addToCartButton: Button =itemView.findViewById(R.id.home_menu_item_menu_add_to_cart);
        val mockButton: Button =itemView.findViewById(R.id.home_menu_item_menu_mock_button);
        val quantity:TextView=itemView.findViewById(R.id.home_menu_item_menu_quantity);

    }

    @SuppressLint("ClickableViewAccessibility", "ResourceAsColor", "SetTextI18n")
    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menu = menu[position]

        if(filter=="none"){
            holder.card.visibility=View.VISIBLE

        }else{
            if(menu.sub_type==filter){
                holder.card.visibility=View.VISIBLE
            }else{
                holder.card.visibility=View.GONE
            }
        }

        val picasso: Picasso = Picasso.get()
        picasso.isLoggingEnabled = false
        picasso.setIndicatorsEnabled(false)
        picasso.load(menu.imageLink).networkPolicy(NetworkPolicy.OFFLINE).into(holder.image, object : Callback {
            override fun onSuccess() {
            }

            override fun onError(e: Exception?) {
                //  ------------------IF IMAGE IS NOT AVAILABLE OFFLINE YET , DO IT ONLINE -------------
                val picasso: Picasso = Picasso.get()
                picasso.isLoggingEnabled = false
                picasso.setIndicatorsEnabled(false)
                picasso.load(menu.imageLink).into(holder.image)
            }
        })

        holder.name.text = menu.name
        holder.description.text = menu.description;
        holder.quantity.text=menu.quantity;
        holder.addToCartButton.text=menu.price.toString()+" usd"

        holder.addToCartButton.setOnClickListener {
              cartListener.addItemToCart(menu.id)
        }

        holder.addToCartButton.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_UP) {
            } else if (event.action == MotionEvent.ACTION_DOWN) {
                holder.addToCartButton.visibility=View.GONE
                holder.mockButton.visibility=View.VISIBLE
                val handlerEnd = Handler()
                handlerEnd.postDelayed(Runnable { holder.mockButton.visibility=View.GONE
                    holder.addToCartButton.visibility=View.VISIBLE}, (400).toLong())
            }
            false
        }

    }

    override fun getItemCount() = menu.size

    interface CartListener {
        fun addItemToCart(id: Long)
    }

}