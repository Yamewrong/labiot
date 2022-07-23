package com.yamewrong.labiot.net

import com.yamewrong.labiot.net.HttpRequestable

interface HttpTransactionCallback
{
    fun transactionBegin(protocol: HttpRequestable)

    fun transactionEnd(protocol: HttpRequestable)
}