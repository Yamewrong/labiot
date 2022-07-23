package com.yamewrong.labiot.protocol

import com.yamewrong.labiot.HTTP_GET_Model
import com.yamewrong.labiot.cin
import com.yamewrong.labiot.net.AbstractHttpProtocol
import com.yamewrong.labiot.net.HttpConst

class PostProtocol: AbstractHttpProtocol<HTTP_GET_Model>() {
    val PATH = "Mobius/virtualStore"
    override fun getUrl(): String =   PATH

    override fun addRequestHeader(strKey: String, strVal: String) {

    }

    override fun getRequestHeaderMap(): Map<String, String> {
        val header = HashMap<String, String>()
        header["X-M2M-RI"] =  "12345"
        header["X-M2M-Origin"] =  "SvirtualStore"
        header["Content-Type"] = "application/vnd.onem2m-res+json; ty=50"
        return header

    }


    override fun getMethod(): Int = HttpConst.HTTP_POST

}