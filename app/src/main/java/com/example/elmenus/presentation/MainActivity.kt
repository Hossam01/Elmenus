package com.example.elmenus.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.example.elmenus.base.BaseActivity
import com.example.elmenus.databinding.ActivityMainBinding
import com.example.elmenus.presentation.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private val mainModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }



}