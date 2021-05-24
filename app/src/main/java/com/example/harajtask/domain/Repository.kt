package com.example.harajtask.domain

import com.example.harajtask.data.Post

interface Repository {
   fun getListFromJson() : ArrayList<Post>
}