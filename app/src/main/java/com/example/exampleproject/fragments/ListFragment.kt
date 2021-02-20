package com.example.exampleproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exampleproject.R
import com.example.exampleproject.adapter.RocketsAdapter
import com.example.exampleproject.databinding.FragmentListBinding
import com.example.exampleproject.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    private lateinit var viewModel:ListViewModel
    private lateinit var mAdapter : RocketsAdapter
    private lateinit var binding:FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_list,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.getDataFromList()
        setupAdapter()

        mAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("item",it)
            }
            findNavController().navigate(
                R.id.action_listFragment_to_detailFragment,
                bundle
            )
        }

        viewModel.rocketListLoading.observe(viewLifecycleOwner,{
            if (it){
                binding.pbList.visibility = View.VISIBLE
            }else{
                binding.pbList.visibility = View.GONE
            }
        })

        viewModel.rocketListError.observe(viewLifecycleOwner,{
            if (it){
                binding.pbList.visibility = View.VISIBLE
                binding.tvError.visibility = View.VISIBLE
            }
        })

        viewModel.rocketsList.observe(viewLifecycleOwner,{
            mAdapter.differ.submitList(it)
        })

    }

    private fun setupAdapter() {
        mAdapter = RocketsAdapter()
        rvList.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}