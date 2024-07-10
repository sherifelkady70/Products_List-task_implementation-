package com.route.data.api.model

import com.route.domain.model.ProductsItem

data class ProductsItem(
    val images: List<String?>? = null,
    val thumbnail: String? = null,
    val minimumOrderQuantity: Int? = null,
    val rating: Any? = null,
    val returnPolicy: String? = null,
    val description: String? = null,
    val weight: Int? = null,
    val warrantyInformation: String? = null,
    val title: String? = null,
    val tags: List<String?>? = null,
    val discountPercentage: Any? = null,
    val reviews: List<ReviewsItem?>? = null,
    val price: Any? = null,
    val meta: Meta? = null,
    val shippingInformation: String? = null,
    val id: Int? = null,
    val availabilityStatus: String? = null,
    val category: String? = null,
    val stock: Int? = null,
    val sku: String? = null,
    val dimensions: Dimensions? = null,
    val brand: String? = null
){
    fun toProductsItem() : ProductsItem{
        return ProductsItem(
            images = images,
            thumbnail = thumbnail,
            rating = rating,
            description = description,
            title = title,
            price = price,
            id = id,
            category = category
        )
    }
}
