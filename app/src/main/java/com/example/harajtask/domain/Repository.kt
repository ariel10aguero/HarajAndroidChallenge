package com.example.harajtask.domain

import androidx.lifecycle.MutableLiveData
import com.example.harajtask.data.Post
import java.util.ArrayList

interface Repository {
   fun getListFromJson() : ArrayList<Post>
}