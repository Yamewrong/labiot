//package com.yamewrong.labiot
//
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentActivity
//import androidx.viewpager2.adapter.FragmentStateAdapter
//
//class MainAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
//    override fun getItemCount() : Int = 2
//    override fun createFragment(position: Int): Fragment {
//        return when(position){
//            0-> DataAugmentationActivity()
//            else -> ClassifierFragment()
//        }
//    }
//}