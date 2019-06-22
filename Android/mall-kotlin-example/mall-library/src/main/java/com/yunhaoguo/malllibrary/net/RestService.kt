package com.yunhaoguo.malllibrary.net

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import java.util.*

/*
 * 项目名:     mall-kotlin-example
 * 包名:      com.yunhaoguo.malllibrary.net
 * 文件名:     RestService
 * 创建者:     yunhaoguo
 * 创建时间:    2019/6/13 3:15 PM
 * 描述:      TODO
 */


interface RestService {

    @GET
    fun get(@Url url: String?, @QueryMap params: WeakHashMap<String, Any>?): Call<String>

    @FormUrlEncoded
    @POST
    fun post(@Url url: String?, @QueryMap params: WeakHashMap<String, Any>?): Call<String>

    @FormUrlEncoded
    fun put(@Url url: String?, @QueryMap params: WeakHashMap<String, Any>?): Call<String>

    @DELETE
    fun delete(@Url url: String?, @QueryMap params: WeakHashMap<String, Any>?): Call<String>

    @Streaming
    @GET
    fun download(@Url url: String?, @QueryMap params: WeakHashMap<String, Any>?): Call<ResponseBody>

    fun upload(@Url url: String?, @Part file: MultipartBody.Part?): Call<String>

}