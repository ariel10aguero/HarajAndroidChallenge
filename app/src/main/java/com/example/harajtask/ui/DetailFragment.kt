package com.example.harajtask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.harajtask.R
import com.example.harajtask.databinding.FragmentDetailBinding
import com.example.harajtask.databinding.FragmentHomeBinding


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


         Glide.with(requireContext()).load(args.postArg.thumbURL).optionalCenterCrop().into(binding.photoDetail)

        binding.titleDetailTxt2.text = args.postArg.title
        binding.usernameDetailTxt.text = args.postArg.username
        binding.cityDetailTxt.text = args.postArg.city
        binding.bodyDetail.text = args.postArg.body

        binding.backArrow.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
        }
    }


}

