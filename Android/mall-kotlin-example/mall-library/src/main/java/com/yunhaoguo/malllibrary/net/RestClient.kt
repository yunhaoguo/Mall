package com.yunhaoguo.malllibrary.net

import com.yunhaoguo.malllibrary.net.callback.*
import retrofit2.Call
import retrofit2.Callback
import java.util.*

/*
 * 项目名:     mall-kotlin-example
 * 包名:      com.yunhaoguo.malllibrary.net
 * 文件名:     RestClient
 * 创建者:     yunhaoguo
 * 创建时间:    2019/6/16 9:41 PM
 * 描述:      TODO
 */
class RestClient internal constructor(private var url: String?,
                                      private var params: WeakHashMap<String, Any>?,
                                      private var request: IRequest?,
                                      private var success: ISuccess?,
                                      private var failure: IFailure?,
                                      private var error: IError?,
                                      private var complete: IComplete?) {

    companion object {
        fun builder(): RestClientBuilder {
            return RestClientBuilder()
        }
    }

    private fun request(method: HttpMethod) {
        val service = RestCreator.restService
        val call: Call<String>?
        request?.onRequestStart()

        call = when(method) {

            HttpMethod.GET -> service.get(url, params)
            HttpMethod.POST -> service.post(url, params)
            HttpMethod.PUT -> service.put(url, params)
            HttpMethod.DELETE -> service.delete(url, params)
            HttpMethod.UPLOAD -> TODO()
            HttpMethod.DOWNLOAD -> TODO()
        }
        call.enqueue(requestCallback)
    }

    private val requestCallback: Callback<String>
        get() = RequestCallbacks(request, success, failure, error, complete)


    fun get() {
        request(HttpMethod.GET)
    }

    fun post() {
        request(HttpMethod.POST)
    }

    fun put() {
        request(HttpMethod.PUT)
    }

    fun delete() {
        request(HttpMethod.DELETE)
    }

}
 
 