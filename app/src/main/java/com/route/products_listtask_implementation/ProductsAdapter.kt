package com.route.products_listtask_implementation

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.route.domain.model.ProductsItem
import com.route.products_listtask_implementation.databinding.ProductItemBinding

class ProductsAdapter (private var productsList:List<ProductsItem?>?)
    : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>(){

    fun bindList(myList:List<ProductsItem?>?){
        this.productsList = myList
        notifyDataSetChanged()
    }
    inner class ProductsViewHolder(val binding: ProductItemBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(product:ProductsItem?){
            binding.product = product
            binding.executePendingBindings()
            if (product?.price != null) {
                binding.priceTxt.text = "EGP ${product?.price ?: 0}"
                binding.oldPriceTxt.isVisible = false
                binding.oldPriceTxt.text = "EGP ${product?.price ?: 0}"
                binding.oldPriceTxt.paintFlags =
                    binding.oldPriceTxt.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                binding.priceTxt.text = "EGP ${product?.price ?: 0}"
                binding.oldPriceTxt.isVisible = false
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        return ProductsViewHolder(
            ProductItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = productsList?.size ?: 0

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = productsList!![position]
        holder.bind(product)
    }
}