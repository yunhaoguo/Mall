package com.yunhaoguo.malllibrary.global

import android.content.Context
import com.yunhaoguo.malllibrary.util.storage.MemoryStore

/*
 * 项目名:     mall-kotlin-example
 * 包名:      com.yunhaoguo.malllibrary.global
 * 文件名:     Mall
 * 创建者:     yunhaoguo
 * 创建时间:    2019/6/13 2:36 PM
 * 描述:      TODO
 */
 
 
object Mall {

    private val configurator: Configurator
        get() = Configurator.instance

    fun init(context: Context): Configurator {
        MemoryStore.instance.addData(
            GlobalKeys.APPLICATION_CONTEXT,
            context
        )
        return configurator
    }

    fun <T> getConfiguration(key: String): T {
        return configurator.getConfiguration(key)
    }

    fun <T> getConfiguration(key: Enum<GlobalKeys>): T {
        return configurator.getConfiguration(key.name)
    }
}