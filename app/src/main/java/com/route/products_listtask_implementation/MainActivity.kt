package com.route.products_listtask_implementation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.route.domain.model.ProductsItem
import com.route.products_listtask_implementation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private val productsAdapter = ProductsAdapter()
    private lateinit var binding : ActivityMainBinding
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
    private fun observeOnData(){
        viewModel.getProductsList()
        viewModel.productsList.observe(this){
            productsAdapter.bindList(it)
            binding.shimmerEffect.isVisible = false
            binding.shimmerEffect.stopShimmer()
        }
    }
}