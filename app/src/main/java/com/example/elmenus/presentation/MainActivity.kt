package com.example.elmenus.presentation

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.elmenus.R
import com.example.elmenus.databinding.ActivityMainBinding
import com.example.elmenus.presentation.home.HomeViewModel
import com.example.elmenus.presentation.home.TagAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter=TagAdapter()
        lifecycleScope.launch {
            mainModel.userItemsUiStates.collect {
                it->adapter.submitData(it)
            }
        }
        binding.rvArticleslist.adapter=adapter
    }

}