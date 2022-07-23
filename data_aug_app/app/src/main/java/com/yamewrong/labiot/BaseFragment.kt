package com.yamewrong.labiot.base

import com.yamewrong.labiot.Trace
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yamewrong.labiot.activity.BaseActivity

open class BaseFragment: Fragment() {
    protected var mActivity: BaseActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity as BaseActivity
        Trace.debug(">> onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Trace.debug(">> onCreateView()")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Trace.debug(">> onStart")
    }

    override fun onResume() {
        super.onResume()
        Trace.debug(">> onResume()")
    }

    override fun onPause() {
        super.onPause()
        Trace.debug(">> onPause()")
    }

    override fun onStop() {
        super.onStop()
        Trace.debug(">> onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Trace.debug(">> onDestroy()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Trace.debug(">> onDestroy()")
    }
}