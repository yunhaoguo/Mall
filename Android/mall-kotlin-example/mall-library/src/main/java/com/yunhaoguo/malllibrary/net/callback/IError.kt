package com.yunhaoguo.malllibrary.net.callback

/*
 * 项目名:     mall-kotlin-example
 * 包名:      com.yunhaoguo.malllibrary.net.callback
 * 文件名:     IError
 * 创建者:     yunhaoguo
 * 创建时间:    2019-06-18 08:20
 * 描述:      TODO
 */


interface IError {

    fun onError(code: Int, msg: String)
}