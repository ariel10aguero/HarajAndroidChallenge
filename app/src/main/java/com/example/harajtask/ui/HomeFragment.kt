package com.example.harajtask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harajtask.R
import com.example.harajtask.Utils
import com.example.harajtask.data.Post
import com.example.harajtask.databinding.FragmentHomeBinding
import com.example.harajtask.domain.RepoImplement
import com.example.harajtask.viewmodel.MainViewModel
import com.example.harajtask.viewmodel.ViewModelFactory


class HomeFragment : Fragment(), RecyclerAdapter.OnClickRowListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    lateinit var recyclerAdapter: RecyclerAdapter
    private val viewModel by activityViewModels<MainViewModel>(){
        ViewModelFactory(RepoImplement(requireContext()))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerAdapter = RecyclerAdapter(this, Utils())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycer()
        fetchList()

    }

    private fun setUpRecycer() {
        binding.recycler.adapter = recyclerAdapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun fetchList(){
        val list = viewModel.getListFromJson()
        recyclerAdapter.setlist(list)
    }

    override fun onClickRow(post: Post) {
        val postDetail = HomeFragmentDirections.actionHomeFragmentToDetailFragment(post)
        findNavController().navigate(postDetail)
    }
}