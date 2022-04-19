package com.example.elmenus.presentation.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.elmenus.data.local.model.TagModel
import com.example.elmenus.data.remote.dto.ItemListDto
import com.example.elmenus.data.repository.DataRepoImpl
import com.example.elmenus.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject
 constructor(private val dataRepo: DataRepoImpl) : ViewModel(){

    private val itemDataList = MutableStateFlow<Resource<ItemListDto>>(Resource.loading(null))


    fun getItemDataList()=itemDataList

    fun getDataItem(name:String) = viewModelScope.launch {
        itemDataList.emit(Resource.loading(null))
        dataRepo.getItemsData(name).let {
            if (it.isSuccessful)
            {
                itemDataList.emit(Resource.success(it.body()))
            }else{
                itemDataList.emit(Resource.error(it.errorBody().toString(), null))
            }
        }

    }

    val userItemsUiStates = dataRepo.getTags()

        .map { pagingData ->
            pagingData.map { tagModel -> TagItemUiState(tagModel)
                val original = listOf(TagModel(tagModel.tagName,tagModel.photoURL))
                dataRepo.saveTags(original)
            }
        }.cachedIn(viewModelScope)







}