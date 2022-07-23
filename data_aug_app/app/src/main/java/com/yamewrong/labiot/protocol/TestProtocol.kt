package com.yamewrong.labiot.protocol

import com.yamewrong.labiot.HTTP_GET_Model
import com.yamewrong.labiot.cin
import com.yamewrong.labiot.net.AbstractHttpProtocol
import com.yamewrong.labiot.net.HttpConst

class TestProtocol: AbstractHttpProtocol<HTTP_GET_Model>() {
    val PATH = "Mobius/virtualStore/classifier/target/la"
    override fun getUrl(): String =   PATH

    override fun addRequestHeader(strKey: String, strVal: String) {

    }

    override fun getRequestHeaderMap(): Map<String, String> {
        val header = HashMap<String, String>()
        header["X-M2M-RI"] =  "12345"
        header["X-M2M-Origin"] =  "SvirtualStore"
        return header

    }

//    override fun getResponseHeader(strKey: String, nSubIndex: Int): String {
//        return super.getResponseHeader(strKey, nSubIndex).run {
//            val header =  HashMap<String, Any>()
//
//        }
//    }

    override fun getMethod(): Int = HttpConst.HTTP_GET

}