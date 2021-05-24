package com.example.harajtask.domain

import android.content.Context
import android.content.res.AssetManager
import android.system.Os.open
import android.util.Log
import com.example.harajtask.data.Post
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream
import java.nio.channels.AsynchronousFileChannel.open
import java.nio.channels.DatagramChannel.open


class RepoImplement(private val context: Context) : Repository {

    override fun getListFromJson(): ArrayList<Post> {

        var json: String? = null

        try {
            val inputStream: InputStream = context.assets.open("data.json")
            json = inputStream.bufferedReader().use { it.readText() }
            Log.d("hola", "$json")
        }
        catch (e: IOException){
            Log.d("Error", "Can't open Json File")
        }

        val gson = Gson()
        val myType = object : TypeToken<ArrayList<Post>>() {}.type
        val logs = gson.fromJson<ArrayList<Post>>(json, myType)

        Log.d("chau", "$logs")
        Log.d("uno", "${logs[2]}")
        return logs


    }
}