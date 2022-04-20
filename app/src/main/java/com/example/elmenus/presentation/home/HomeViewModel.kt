package com.example.elmenus.presentation.home

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.elmenus.data.local.model.ItemModel
import com.example.elmenus.data.remote.dto.ItemDto
import com.example.elmenus.data.remote.dto.ItemListDto
import com.example.elmenus.data.remote.dto.TagDto
import com.example.elmenus.data.repository.DataRepoImpl
import com.example.elmenus.util.Resource
import com.example.elmenus.util.helper.NetworkStatusHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import okhttp3.internal.toImmutableList

class HomeViewModel @ViewModelInject
 constructor(private val dataRepo: DataRepoImpl,private val networkHelper: NetworkStatusHelper) : ViewModel(){

    private val itemDataList = MutableStateFlow<Resource<ItemListDto>>(Resource.loading(null))
    var list=mutableListOf<ItemModel>()
    val mutableListItem = mutableListOf<ItemDto>()

    fun getItemDataList()=itemDataList


    fun getDataItem(name:String) = viewModelScope.launch {

        if (networkHelper.isNetworkConnected()) {
            itemDataList.emit(Resource.loading(null))
            dataRepo.getItemsData(name).let {
                if (it.isSuccessful) {
                    itemDataList.emit(Resource.success(it.body()))
                    for (items in it.body()!!.items) {
                        list.add(ItemModel(items.photoUrl, items.name, items.description, items.id))
                    }
                    dataRepo.addAllItems(list)
                } else {
                    itemDataList.emit(Resource.error(it.errorBody().toString(), null))
                }
            }
        }
        else{
            dataRepo.getitem(name).let {
             if(it.size>0)
             {
                 mutableListItem.clear()
                 for (item in it)
                 {
                     mutableListItem.add(ItemDto(item.photoUrl,item.name,item.description,item.id))
                 }
                 itemDataList.emit(Resource.loading(null))

                 itemDataList.emit(Resource.success(ItemListDto(mutableListItem)))
             }
         }
        }
    }

    fun userItemsUiStates(): Flow<PagingData<TagItemUiState>> {
        Log.d("TAG", "userItemsUiStates: "+networkHelper.isNetworkConnected())
        if (networkHelper.isNetworkConnected()) {
            return dataRepo.getTags()
                .map { pagingData ->
                    pagingData.map { tagModel ->
                        TagItemUiState(tagModel)
                    }
                }.cachedIn(viewModelScope)
        }
        else
        {
            return dataRepo.getlocalTags()
                .map {
                        pagingData->pagingData.map {
                        tagModel -> TagItemUiState(TagDto(tagModel.photoURL,tagModel.tagName))
                }
                }.cachedIn(viewModelScope)
        }

    }


}