package com.example.kunuz3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kunuz3.databinding.PostViewBinding
import com.example.kunuz3.datas.Post

class PostsAdapter(var posts:MutableList<Post>, var forPostClick: ForPostClick) : RecyclerView.Adapter<PostsAdapter.PostHolder>(){
    class PostHolder(binding: PostViewBinding) : RecyclerView.ViewHolder(binding.root){
            var p_img = binding.imageView
            var p_date = binding.postD
            var p_text = binding.postT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        return PostHolder(PostViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        var post = posts[position]
        holder.p_img.setImageResource(post.post_img)
        holder.p_date.text = post.post_date
        holder.p_text.text = post.post_text

        holder.itemView.setOnClickListener {
            forPostClick.onItemClick(post)
        }

    }

    override fun getItemCount(): Int {
        return posts.size
    }

    interface ForPostClick{
        fun onItemClick(post: Post)
    }


}