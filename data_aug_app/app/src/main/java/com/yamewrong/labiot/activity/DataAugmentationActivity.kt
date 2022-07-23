package com.yamewrong.labiot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.yamewrong.labiot.adpater.RVAdapter
import com.yamewrong.labiot.databinding.FragmentDataAugmentationBinding


class DatasAugmentationActivity() : AppCompatActivity() {
    private val items = mutableListOf<ContentModel>()
    lateinit var mBinding : FragmentDataAugmentationBinding
    lateinit var data : HTTP_GET_Model
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data = intent.getSerializableExtra("data") as HTTP_GET_Model
        mBinding = DataBindingUtil.setContentView(this, R.layout.fragment_data_augmentation)
        items.add(
            ContentModel(
                "http://127.0.0.1:7579",
                data.Cin.con,
                data.Cin.rn
            )
        )


        val recyclerView = mBinding.fdRv
        val rvAdapter = RVAdapter(this,items)
        recyclerView.adapter = rvAdapter
        recyclerView.layoutManager = GridLayoutManager(this,2)
    }

}
