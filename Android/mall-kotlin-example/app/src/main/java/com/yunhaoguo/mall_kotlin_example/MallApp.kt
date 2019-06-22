package com.yunhaoguo.mall_kotlin_example

import android.app.Application
import com.yunhaoguo.malllibrary.global.Mall

/*
 * 项目名:     mall-kotlin-example
 * 包名:      com.yunhaoguo.mall_kotlin_example
 * 文件名:     MallAPp
 * 创建者:     yunhaoguo
 * 创建时间:    2019/6/13 2:39 PM
 * 描述:      TODO
 */
class MallApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Mall.init(this)
            .withApiHost("http://mock.fulingjie.com/mock-android/api/")
            .configure()
    }
}