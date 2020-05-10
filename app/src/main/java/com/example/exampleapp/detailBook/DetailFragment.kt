package com.example.exampleapp.detailBook

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.example.exampleapp.R
import com.example.exampleapp.databinding.BookFragmentBinding
import com.example.exampleapp.databinding.DetailFragmentBinding
import com.example.exampleapp.mainBooks.BookViewModel

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var application = requireNotNull(activity).application
        var binding: DetailFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.detail_fragment, container, false)
        binding.setLifecycleOwner(this)
        val book = DetailFragmentArgs.fromBundle(requireArguments()).selectedBook
        val VMFactory = DetailViewModelFactory(book,application)
        viewModel= ViewModelProvider(this,VMFactory).get(DetailViewModel::class.java)
        binding.vm = viewModel

        return binding.root
    }



}
