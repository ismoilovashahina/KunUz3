package com.example.kunuz3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.kunuz3.adapter.PostsAdapter
import com.example.kunuz3.databinding.FragmentKunUzMainBinding
import com.example.kunuz3.datas.Post

class KunUzMainFragment : Fragment() {

    private lateinit var postList: MutableList<Post>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        postList = mutableListOf()
        for (i in 0..15){
            postList.add(Post(R.drawable.post1img, "17:53 / 28.03.2023", "Experts: Taliban’s “megaproject” could leave all of Central Asia without water"))
            postList.add(Post(R.drawable.img2, "16:14 / 24.03.2023", "MES publishes list of Uzbek cities and towns located in seismically active zones"))
            postList.add(Post(R.drawable.img3, "14:44 / 13.03.2023", "Shavkat Mirziyoyev speaks about Uzbekistan’s position in foreign policy"))
            postList.add(Post(R.drawable.img4, "11:04 / 10.03.2023", "Uzbekistan, Kyrgyzstan discuss construction of Kambarata HPP-1"))
        }
        val binding = FragmentKunUzMainBinding.inflate(inflater, container, false)
        binding.recyclerview.adapter = PostsAdapter(postList, object : PostsAdapter.ForPostClick{
            override fun onItemClick(post: Post) {
                val bundle = bundleOf("post" to post)
                findNavController().navigate(R.id.action_kunUzMainFragment_to_postFragment, bundle)
            }

        })
        return binding.root
    }

}