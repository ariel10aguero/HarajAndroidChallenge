package com.example.harajtask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.harajtask.data.Post
import com.example.harajtask.domain.Repository
import java.util.ArrayList

class MainViewModel(private val repo: Repository) : ViewModel() {

    var liveDataList = MutableLiveData<ArrayList<Post>>()

    fun getListFromJson(){
        liveDataList.value = repo.getListFromJson()
    }


}