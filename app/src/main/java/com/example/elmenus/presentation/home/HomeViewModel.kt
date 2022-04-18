package com.example.elmenus.presentation.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.elmenus.data.repository.DataRepoImpl
import com.example.elmenus.domain.repositry.DataRepo
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject
 constructor(dataRepo: DataRepoImpl) : ViewModel(){

    val userItemsUiStates = dataRepo.getTags()
        .map { pagingData ->
            pagingData.map { tagModel -> TagItemUiState(tagModel) }
        }.cachedIn(viewModelScope)

}