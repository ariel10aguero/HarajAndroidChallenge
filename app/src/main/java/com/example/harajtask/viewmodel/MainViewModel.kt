package com.example.harajtask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.harajtask.data.Post
import com.example.harajtask.domain.Repository
import java.util.ArrayList

class MainViewModel(private val repo: Repository) : ViewModel() {

    fun getListFromJson(): ArrayList<Post>{
       return repo.getListFromJson()
    }


}