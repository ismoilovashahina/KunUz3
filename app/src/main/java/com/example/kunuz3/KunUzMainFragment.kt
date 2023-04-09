package com.example.kunuz3

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kunuz3.adapter.PostsAdapter
import com.example.kunuz3.databinding.FragmentKunUzMainBinding
import com.example.kunuz3.datas.Post
import java.util.*

class KunUzMainFragment : Fragment() {

    private lateinit var postList: MutableList<Post>
    private lateinit var adapter: PostsAdapter

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

        adapter = PostsAdapter(postList, object : PostsAdapter.ForPostClick{
            override fun onItemClick(post: Post) {
                val bundle = bundleOf("post" to post)
                findNavController().navigate(R.id.action_kunUzMainFragment_to_postFragment, bundle)
            }
        })

        binding.recyclerview.adapter = adapter

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })

        return binding.root
    }

    private fun filterList(query:String?){
        if(query != null){
            val filteredList = mutableListOf<Post>()
            for (i in postList){
                if (i.post_text.lowercase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }
            if (filteredList.isEmpty()){
                Toast.makeText(context, "NO Data found", Toast.LENGTH_SHORT).show()
            } else{
                adapter.setFilteredList(filteredList)
            }
        }
    }

}
