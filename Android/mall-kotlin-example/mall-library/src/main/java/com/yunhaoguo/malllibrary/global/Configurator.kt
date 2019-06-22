package com.yunhaoguo.malllibrary.global

import android.os.Handler
import com.yunhaoguo.malllibrary.util.storage.MemoryStore

/*
 * 项目名:     mall-kotlin-example
 * 包名:      com.yunhaoguo.malllibrary.global
 * 文件名:     Configurator
 * 创建者:     yunhaoguo
 * 创建时间:    2019/6/13 7:53 AM
 * 描述:      全局配置控制类
 */

class Configurator {

    private object Holder {
        internal val INSTANCE = Configurator()
    }

    companion object {
        private val mStore = MemoryStore.instance
        private val mHandler = Handler()

        internal val instance: Configurator
            get() = Holder.INSTANCE
    }

    init {
        mStore.addData(GlobalKeys.IS_CONFIGURE_READY, false)
        mStore.addData(GlobalKeys.HANDLER, mHandler)

    }

    /**
     * 访问服务器端API设置
     */
    fun withApiHost(host: String): Configurator {
        mStore.addData(GlobalKeys.API_HOST, host)
        return this
    }

    /**
     * 结束配置
     */
    fun configure() {
        mStore.addData(GlobalKeys.IS_CONFIGURE_READY, true)
        //下面做一些回收

    }

    fun <T> getConfiguration(key: String): T {
        checkConfiguration()
        return mStore.getData(key)
    }

    fun <T> getConfiguration(key: Enum<*>): T {
        return getConfiguration(key.name)
    }

    private fun checkConfiguration() {
        val isReady = mStore.getData<Boolean>(GlobalKeys.IS_CONFIGURE_READY)
        if (!isReady) {
            throw RuntimeException("Config is not ready.")
        }
    }
}
 
 