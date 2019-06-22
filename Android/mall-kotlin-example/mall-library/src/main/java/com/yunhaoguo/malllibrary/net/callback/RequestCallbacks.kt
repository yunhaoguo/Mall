package com.yunhaoguo.malllibrary.net.callback

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
 * 项目名:     mall-kotlin-example
 * 包名:      com.yunhaoguo.malllibrary.net.callback
 * 文件名:     RequestCallbacks
 * 创建者:     yunhaoguo
 * 创建时间:    2019-06-18 08:51
 * 描述:      TODO
 */
 
class RequestCallbacks(
    private val request: IRequest?,
    private val success: ISuccess?,
    private val failure: IFailure?,
    private val error: IError?,
    private val complete: IComplete?
): Callback<String> {

    override fun onFailure(call: Call<String>, t: Throwable) {
        Log.i("fail", t.message)
        failure?.onFailure()
        request?.onRequestEnd()
    }

    override fun onResponse(call: Call<String>, response: Response<String>) {
        if (response.isSuccessful) {
            Log.i("success", "1")
            if (call.isExecuted) {
                if (success != null) {
                    val result = response.body()
                    if (result != null) {
                        success.onSuccess(result)
                    }
                }
            }
        } else {
            Log.i("fail", "2")
            error?.onError(response.code(), response.message())
        }
    }

}