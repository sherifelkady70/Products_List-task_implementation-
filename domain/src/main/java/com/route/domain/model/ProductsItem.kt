package com.route.domain.model

data class ProductsItem(
    val images: List<String?>? = null,
    val thumbnail: String? = null,
    val rating: Any? = null,
    val description: String? = null,
    val title: String? = null,
    val price: String? = null,
    val id: Int? = null,
    val category: String? = null,
)
