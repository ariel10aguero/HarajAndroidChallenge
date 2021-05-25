package com.example.harajtask.ui

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.harajtask.R
import com.example.harajtask.Utils
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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val utils = Utils()
         Glide.with(requireContext()).load(args.postArg.thumbURL).optionalCenterCrop().into(binding.photoDetail)

        binding.apply {
            titleDetailTxt2.text = args.postArg.title
            usernameDetailTxt.text = args.postArg.username
            cityDetailTxt.text = args.postArg.city
            bodyDetail.text = args.postArg.body
            dateDetailTxt.text = utils.getCompleteDate(args.postArg.date)
            backArrow.setOnClickListener {
                findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
            }
        }
    }


}

