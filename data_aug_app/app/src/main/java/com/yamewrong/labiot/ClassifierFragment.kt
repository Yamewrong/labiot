package com.yamewrong.labiot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.yamewrong.labiot.adpater.RVAdapter
import com.yamewrong.labiot.databinding.FragmentClassifierBinding


class ClassifierFragment : Fragment() {
   private val items = mutableListOf<ContentModel>()
    lateinit var mBinding : FragmentClassifierBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items.add(
            ContentModel(
                "http://127.0.0.1:7579",
                "http://127.0.0.1:7579",
                "http://127.0.0.1:7579"
            )
        )
        items.add(
            ContentModel(
                "http://127.0.0.1:7579",
                "http://127.0.0.1:7579",
                "http://127.0.0.1:7579"
            )
        )
        items.add(
            ContentModel(
                "http://127.0.0.1:7579",
                "http://127.0.0.1:7579",
                "http://127.0.0.1:7579"
            )
        )
        items.add(
            ContentModel(
                "http://127.0.0.1:7579",
                "http://127.0.0.1:7579",
                "http://127.0.0.1:7579"
            )
        )
        items.add(
            ContentModel(
                "http://127.0.0.1:7579",
                "http://127.0.0.1:7579",
                "http://127.0.0.1:7579"
            )
        )

        items.add(
            ContentModel(
                "http://127.0.0.1:7579",
                "http://127.0.0.1:7579",
                "http://127.0.0.1:7579"
            )
        )
        items.add(
            ContentModel(
                "http://127.0.0.1:7579",
                "http://127.0.0.1:7579",
                "http://127.0.0.1:7579"
            )
        )
        items.add(
            ContentModel(
                "http://127.0.0.1:7579",
                "http://127.0.0.1:7579",
                "http://127.0.0.1:7579"
            )
        )


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_classifier,container,false)

        val recyclerView = mBinding.fcRv
        val rvAdapter = RVAdapter(requireContext(),items)
        recyclerView.adapter = rvAdapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        return mBinding.root    }

}