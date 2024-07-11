package com.route.products_listtask_implementation.utils

data class ViewMessage(
    var title: String? = null,
    var message: String? = null,
    var posBtnTitle: String? = null,
    var onPosBtnClick: (() -> Unit)? = null,
    var onNegBtnClick: (() -> Unit)? = null,
    var negBtnTitle: String? = null,
)
