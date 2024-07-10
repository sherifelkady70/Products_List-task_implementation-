package com.route.data.api.model

data class ProductResponse<T>(
    val total: Int? = null,
    val limit: Int? = null,
    val skip: Int? = null,
    val data:T?=null,
    val meta :Meta?=null,
    val dimensions  :Dimensions?=null,
    val reviewsItem: ReviewsItem?=null
)
