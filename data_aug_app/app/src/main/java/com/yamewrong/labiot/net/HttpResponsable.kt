package com.yamewrong.labiot.net

import com.yamewrong.labiot.Trace

interface HttpResponsable<in RES>
{
    fun onResponse(res: RES)

    fun onFailure(nError: Int, strMsg: String) {
        Trace.debug(">> onFailure() $strMsg[$nError]")
    }
}