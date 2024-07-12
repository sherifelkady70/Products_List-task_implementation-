package com.route.products_listtask_implementation

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.route.domain.utils.Resource
import com.route.products_listtask_implementation.adapter.ProductsAdapter
import com.route.products_listtask_implementation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private val productsAdapter = ProductsAdapter()
    private lateinit var binding : ActivityMainBinding
    private var dialog : AlertDialog?=null
    private val viewModel : ProductsViewModel by viewModels<ProductsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.lifecycleOwner=this
        initViews()
        observeOnData()

    }

    private fun initViews(){
        binding.productsRv.adapter = productsAdapter
        binding.shimmerEffect.isVisible = true
        binding.shimmerEffect.startShimmer()
    }
    private fun observeOnData() {
        viewModel.getProductsList()
        viewModel.productsList.observe(this) {
            productsAdapter.bindList(it)
            binding.shimmerEffect.isVisible = false
            binding.shimmerEffect.stopShimmer()
        }
        viewModel.viewMessage.observe(this){
            showDialog(it.toString())
        }
        viewModel.loading.observe(this){

        }
    }


    private fun showLoading(){
        val builder = AlertDialog.Builder(this)
        builder.setView(R.layout.loading)
        dialog = builder.create()
        dialog?.show()
    }
    private fun hideLoading(){
        dialog?.dismiss()
    }
    private fun showDialog(
        title: String? = null,
        message: String? = null,
        posBtnTitle: String? = null,
        onPosBtnClick: (() -> Unit)? = null,
        onNegBtnClick: (() -> Unit)? = null,
        negBtnTitle: String? = null,


        ) {
        val myDialog = AlertDialog.Builder(this)
        myDialog.setTitle(title)
        myDialog.setMessage(message)
        posBtnTitle.let {
            myDialog.setPositiveButton(posBtnTitle,
                object : DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        dialog?.dismiss()
                        onPosBtnClick?.invoke()
                    }

                })
        }
        negBtnTitle.let {
            myDialog.setNegativeButton(negBtnTitle
            ) { dialog, which ->
                dialog?.dismiss()
                onNegBtnClick?.invoke()
            }
        }

        myDialog.create().show()

    }
}