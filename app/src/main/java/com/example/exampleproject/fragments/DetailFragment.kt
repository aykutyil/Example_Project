package com.example.exampleproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.exampleproject.R
import com.example.exampleproject.databinding.DetailFragmentBinding
import com.example.exampleproject.model.RocketsItem
import com.example.exampleproject.viewmodel.DetailViewModel

class DetailFragment: Fragment() {

    lateinit  var rocketItem:RocketsItem
    private lateinit var viewModel:DetailViewModel

    private lateinit var binding: DetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.detail_fragment,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            rocketItem = it.getSerializable("item") as RocketsItem
        }
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        viewModel.getSingleItem(rocketItem.rocketİd!!)

        viewModel.rocketItem.observe(viewLifecycleOwner,{
            binding.item = it
        })

        viewModel.rocketListLoading.observe(viewLifecycleOwner,{
            if (it)
                binding.pbLoading.visibility = View.VISIBLE
            else
                binding.pbLoading.visibility = View.GONE
        })


    }
}