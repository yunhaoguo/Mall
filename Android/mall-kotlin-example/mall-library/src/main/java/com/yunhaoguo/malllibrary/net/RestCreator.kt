package com.yunhaoguo.malllibrary.net

import com.yunhaoguo.malllibrary.global.GlobalKeys
import com.yunhaoguo.malllibrary.global.Mall
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/*
 * 项目名:     mall-kotlin-example
 * 包名:      com.yunhaoguo.malllibrary.net
 * 文件名:     RestCreator
 * 创建者:     yunhaoguo
 * 创建时间:    2019/6/13 3:25 PM
 * 描述:      TODO
 */

object RestCreator {

    private object OkHttpHolder {
        private val TIME_OUT = 60
        private val BUILDER = OkHttpClient.Builder()
        internal val OK_HTTP_CLIENT = BUILDER
            .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .build()
    }

    private object RetrofitHolder {
        private val BASE_URL = Mall.getConfiguration<String>(GlobalKeys.API_HOST)

        internal val RETROFIT_CLIENT = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpHolder.OK_HTTP_CLIENT)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    private object RestServiceHolder {
        internal val REST_SERVICE = RetrofitHolder.RETROFIT_CLIENT
            .create(RestService::class.java)
    }

    val restService: RestService
        get() = RestServiceHolder.REST_SERVICE
}