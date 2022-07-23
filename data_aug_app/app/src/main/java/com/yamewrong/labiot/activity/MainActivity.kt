package com.yamewrong.labiot.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.yamewrong.labiot.DatasAugmentationActivity
import com.yamewrong.labiot.HTTP_GET_Model
import com.yamewrong.labiot.Network
import com.yamewrong.labiot.databinding.ActivityMainBinding
import com.yamewrong.labiot.net.HttpResponsable
import com.yamewrong.labiot.net.NetworkManager
import com.yamewrong.labiot.net.ProtocolFactory
import com.yamewrong.labiot.protocol.TestProtocol

class MainActivity : BaseActivity() {
    lateinit var mBinding: ActivityMainBinding
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val api = Network();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.ambtn1.setOnClickListener {

            val protocol = ProtocolFactory.create(TestProtocol::class.java)
            protocol.addRequestHeader("X-M2M-RI", "12345")
            protocol.addRequestHeader("X-M2M-Origin", "justin")
            Log.e("header", "header = ${protocol.getRequestHeaderMap()}")

//
//            "X-M2M-RI:12345",
//            "X-M2M-Origin:justin"
            protocol.setHttpResponsable(object : HttpResponsable<HTTP_GET_Model> {
                override fun onResponse(res: HTTP_GET_Model) {
                    Log.e("onResponse", "onResponse() == $res")

                    val intent=Intent(this@MainActivity, DatasAugmentationActivity::class.java)
                    intent.putExtra("data", res)
                    startActivity(intent)
                }

            }
            )

            NetworkManager.getInstance().asyncRequest(protocol)

//            api.get_users().enqueue(object : Callback<cin>{
//                override fun onResponse(call: Call<cin>,response:Response<cin>){
//                    Log.d("log",response.toString())
//                    Log.d("log",response.body().toString())
//                    if(!response.body().toString().isEmpty())
//                        binding.text.setText(response.body().toString());
//                }
//                override fun onFailure(call:Call<cin>,t:Throwable){
//                    Log.d("log",t.message.toString())
//                    Log.d("log","fail")
//                }
//            }
//            )
        }
//        binding.postbutton.setOnClickListener {
//            val data = PostModel(binding.idedt.text.toString(),binding.pwdedt.text.toString(),binding.nickedt.text.toString())
//            api.post_users(data).enqueue(object : Callback<PostResult> {
//                override fun onResponse(call: Call<PostResult>, response: Response<PostResult>) {
//                    Log.d("log",response.toString())
//                    Log.d("log", response.body().toString())
//                    if(!response.body().toString().isEmpty())
//                        binding.text.setText(response.body().toString());
//                }
//
//                override fun onFailure(call: Call<PostResult>, t: Throwable) {
//                    // 실패
//                    Log.d("log",t.message.toString())
//                    Log.d("log","fail")
//                }
//            })
        }
//        setLayout()

    }
//    fun setLayout(){
//        mAdatper = MainAdapter(this)
//        mBinding.amVpPager.adapter =mAdatper
//        TabLayoutMediator(
//            mBinding.amTlTab,
//            mBinding.amVpPager
//        ){ tab : TabLayout.Tab, pos: Int->
//            when (pos){
//                0 -> {tab.text="Data Augmentation"}
//                1 -> {tab.text= "Classifier"}
//            }
//        }.attach()
//    }
//}