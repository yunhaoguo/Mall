package com.yunhaoguo.malllibrary.net

import com.yunhaoguo.malllibrary.net.callback.*
import java.util.*

/*
 * 项目名:     mall-kotlin-example
 * 包名:      com.yunhaoguo.malllibrary.net
 * 文件名:     RestClientBuilder
 * 创建者:     yunhaoguo
 * 创建时间:    2019/6/16 9:41 PM
 * 描述:      TODO
 */
 
class RestClientBuilder(
    private var url: String? = null,
    private var request: IRequest? = null,
    private var success: ISuccess? = null,
    private var failure: IFailure? = null,
    private var error: IError? = null,
    private var complete: IComplete? = null
) {

    private val mParams = WeakHashMap<String, Any>()

    fun url(url: String): RestClientBuilder {
        this.url = url
        return this
    }

    fun onRequest(iRequest: IRequest): RestClientBuilder {
        this.request = iRequest
        return this
    }

    fun success(iSuccess: ISuccess): RestClientBuilder {
        this.success = iSuccess
        return this
    }

    fun failure(iFailure: IFailure): RestClientBuilder {
        this.failure = iFailure
        return this
    }

    fun complete(iComplete: IComplete): RestClientBuilder {
        this.complete = iComplete
        return this
    }

    fun error(iError: IError): RestClientBuilder {
        this.error = iError
        return this
    }


    fun params(key: String, value: Any): RestClientBuilder {
        mParams[key] = value
        return this
    }

    fun params(params: WeakHashMap<String, Any>): RestClientBuilder {
        mParams.putAll(params)
        return this
    }

    fun build(): RestClient {
        return RestClient(url, mParams, request, success, failure, error, complete)
    }
}
