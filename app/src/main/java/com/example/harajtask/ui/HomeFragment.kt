package com.example.harajtask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
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
        setUpSearchView()
    }

    private fun setUpRecycer() {
        binding.recycler.adapter = recyclerAdapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun fetchList(){
        viewModel.getListFromJson()
        viewModel.liveDataList.observe(viewLifecycleOwner, Observer {
            recyclerAdapter.setlist(it)
        })
    }

    override fun onClickRow(post: Post) {
        val postDetail = HomeFragmentDirections.actionHomeFragmentToDetailFragment(post)
        findNavController().navigate(postDetail)
    }

    private fun setUpSearchView(){
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchItem(query!!)
                recyclerAdapter.notifyDataSetChanged()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchItem(newText!!)
                recyclerAdapter.notifyDataSetChanged()
                return false
            }
        })
    }
}