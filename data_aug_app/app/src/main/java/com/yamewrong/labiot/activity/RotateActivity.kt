package com.yamewrong.labiot.activity

import Augprm
import com.yamewrong.labiot.dataset.M2mDa
import com.yamewrong.labiot.dataset.PostDataModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.yamewrong.labiot.DatasAugmentationActivity
import com.yamewrong.labiot.HTTP_GET_Model
import com.yamewrong.labiot.R
import com.yamewrong.labiot.databinding.ActivityRotateBinding
import com.yamewrong.labiot.net.HttpResponsable
import com.yamewrong.labiot.net.NetworkManager
import com.yamewrong.labiot.net.ProtocolFactory
import com.yamewrong.labiot.protocol.PostProtocol

class RotateActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityRotateBinding
    lateinit var data: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_rotate)
        data = intent.getStringExtra("data").let { if (it.isNullOrEmpty()) "" else it }
        mBinding.arBtnRotate.setOnClickListener() {
//            mBinding.arEtLeft

            val augprm = Augprm(
                mBinding.arEtAugty.text.toString(),
                mBinding.arEtLabel.text.toString(),
                mBinding.arEtLeft.text.toString(),
                mBinding.arEtRight.text.toString(),
                mBinding.arEtAmount.text.toString()
            )
            //input으로 변경
            val m2mda = M2mDa(augprm, augty = augprm.augty, rn = augprm.label, srsrc = "/virtualStore/classifier/target/water_img1", trgrsrc = "/virtualStore/classifier/target")
            val postDataModel = PostDataModel(m2mda)
            val protocol = ProtocolFactory.create(PostProtocol::class.java)
            protocol.setJsonRequestBody(postDataModel)
            protocol.addRequestHeader("X-M2M-RI", "12345")
            protocol.addRequestHeader("X-M2M-Origin", "justin")
            Log.e("header", "header = ${protocol.getRequestHeaderMap()}")

            protocol.setHttpResponsable(object : HttpResponsable<HTTP_GET_Model> {
                override fun onResponse(res: HTTP_GET_Model) {
                    Log.e("onResponse", "onResponse() == $res")
                    val intent = Intent(this@RotateActivity, DatasAugmentationActivity::class.java)
                    intent.putExtra("data", res)
                    startActivity(intent)
                }
            }
            )
            NetworkManager.getInstance().asyncRequest(protocol)
        }
        Glide.with(this)
            .load(Base64.decode(data, Base64.DEFAULT))
            .into(mBinding.arIvImage)
    }
}