package com.example.kunuz3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kunuz3.databinding.FragmentPostBinding
import com.example.kunuz3.datas.Post

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PostFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPostBinding.inflate(inflater, container, false)
        val p = arguments?.getSerializable("post") as Post

        binding.eachPostI.setImageResource(p.post_img)
        binding.eachPostD.text = p.post_date
        binding.eachPostT.text = p.post_text

        return binding.root

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PostFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}