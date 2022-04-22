package com.example.elmenus.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.elmenus.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.elmenus.databinding.HomeFragmentBinding
import com.example.elmenus.presentation.home.adapter.ItemAdapter
import com.example.elmenus.presentation.home.adapter.TagAdapter
import com.example.elmenus.util.Status
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment: BaseFragment(),TagAdapter.TagAdapterListener {

    private val mainModel: HomeViewModel by viewModels()
    lateinit var adapter: TagAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = HomeFragmentBinding.inflate(layoutInflater)

        adapter = TagAdapter()
        val adapteritem= ItemAdapter()
        binding.rvTagslist.adapter=adapter
        binding.rvItemlist.adapter=adapteritem
        postponeEnterTransition()
        binding.rvItemlist.post { startPostponedEnterTransition() }

        adapter.mListener=this

        lifecycleScope.launch {
            mainModel.userItemsUiStates().collect {
                adapter.submitData(it)
            }
        }

        lifecycleScope.launchWhenStarted {
            mainModel.getItemDataList().collect {
                when (it.status) {
                    Status.OK -> {
                        adapteritem.submitList(it.results!!.items)
                        adapteritem.notifyDataSetChanged()
                        binding.selectTag.visibility=View.GONE
                    }
                    Status.ERROR->{
                        Toast.makeText(requireContext(),it.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        return binding.root
    }
    override fun onTagClicked(name: String) {
        mainModel.getDataItem(name)
        Log.d("TAG121", "onCreateView: "+adapter.snapshot().items.size)
    }

}