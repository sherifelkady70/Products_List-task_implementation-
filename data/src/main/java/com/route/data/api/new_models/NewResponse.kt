package com.route.data.api.new_models


data class NewResponse(
	val total: Int? = null,
	val limit: Int? = null,
	val skip: Int? = null,
	val products: List<ProductsItem?>? = null
)