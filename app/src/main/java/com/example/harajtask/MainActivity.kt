package com.example.harajtask

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.harajtask.data.Post
import com.example.harajtask.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getListFromJson()
    }


    fun getListFromJson(){

        var json: String? = null
        try {
            val inputStream: InputStream = assets.open("data.json")
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
    }
}