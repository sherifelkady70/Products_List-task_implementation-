package com.route.products_listtask_implementation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.route.domain.model.ProductsItem
import com.route.products_listtask_implementation.databinding.ProductItemBinding

class ProductsAdapter (private var productsList:List<ProductsItem?>?)
    : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>(){

    fun addList(myList:List<ProductsItem?>?){
        productsList = myList
        notifyDataSetChanged()
    }
    class ProductsViewHolder(val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root){

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

    override fun getItemCount(): Int = productsList!!.size

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}