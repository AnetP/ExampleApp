package com.example.exampleapp.mainBooks

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

import com.example.exampleapp.R
import com.example.exampleapp.databinding.BookFragmentBinding


class BookFragment : Fragment() {

    companion object {
        fun newInstance() = BookFragment()
    }

    private lateinit var viewModel: BookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: BookFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.book_fragment, container,false)
        binding.setLifecycleOwner(this)
        viewModel= ViewModelProvider(this).get(BookViewModel::class.java)

        binding.vm = viewModel
        binding.RecV.adapter=ImgBookAdapter(onClickListen{
            viewModel.displayDetail(it)
        })

        viewModel.navigtoDetail.observe(viewLifecycleOwner, Observer {
            if(it != null){
               this.findNavController().navigate(BookFragmentDirections.actionBookFragmentToDetailFragment(it))
                viewModel.displayDetailNull()
            }
        })

        return binding.root
    }



}
