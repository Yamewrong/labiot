package com.yamewrong.labiot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.yamewrong.labiot.activity.RotateActivity
import com.yamewrong.labiot.databinding.ActivityDataAugmentationBinding

class DataAugmentation : AppCompatActivity() {
    lateinit var mBinding: ActivityDataAugmentationBinding
    lateinit var data:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_augmentation)
        data = intent.getStringExtra("data").let { if(it.isNullOrEmpty()) "" else it }

        init()
    }

    fun init(){
        mBinding.rotate.setOnClickListener{
            val intent = Intent(this, RotateActivity::class.java)
            intent.putExtra("data", data)
            startActivity(intent)
        }
    }


}
