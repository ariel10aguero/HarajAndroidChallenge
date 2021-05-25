package com.example.harajtask.domain

import android.content.Context
import android.util.Log
import com.example.harajtask.data.Post
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream
import java.util.ArrayList


class RepoImplement(private val context: Context) : Repository {

    override fun getListFromJson(): ArrayList<Post> {

        var json: String? = null

        try {
            val inputStream: InputStream = context.assets.open("data.json")
            json = inputStream.bufferedReader().use { it.readText() }
        }
        catch (e: IOException){
            Log.e("error", "$e")
        }

        val gson = Gson()
        val myType = object : TypeToken<ArrayList<Post>>() {}.type
        val objectList = gson.fromJson<ArrayList<Post>>(json, myType)

        return objectList

    }
}