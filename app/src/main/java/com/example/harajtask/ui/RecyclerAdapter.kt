package com.example.harajtask.ui

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harajtask.Utils
import com.example.harajtask.data.Post
import com.example.harajtask.databinding.ItemRowBinding

class RecyclerAdapter(private val onClick: OnClickRowListener, private val utils: Utils) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var postList = arrayListOf<Post>()

    fun setlist(list: ArrayList<Post>){
        postList = list
    }

    interface OnClickRowListener {
        fun onClickRow(post: Post)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val rowInfalter = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
          return MainViewHolder(rowInfalter)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = postList[position]
        when(holder){
            is MainViewHolder -> holder.bind(currentItem)
        }
        holder.itemView.setOnClickListener {
            if (postList.isNotEmpty()) {
                onClick.onClickRow(postList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    inner class MainViewHolder(val binding: ItemRowBinding) :RecyclerView.ViewHolder(binding.root){

        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(post: Post){
            binding.apply {
                Glide.with(itemView.context.applicationContext).load(post.thumbURL).centerCrop().into(imageView)
                titleTxt.text = post.title
                cityTxt.text = post.city
                dateTxt.text = utils.getMonthAndDay(post.date)
                commentsNum.text = post.commentCount.toString()
                usernameTxt.text = post.username
            }
        }
    }
}