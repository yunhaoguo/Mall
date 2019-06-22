package com.yunhaoguo.malllibrary.util.storage

/*
 * 项目名:     mall-kotlin-example
 * 包名:      com.yunhaoguo.malllibrary.util
 * 文件名:     MemoryStore
 * 创建者:     yunhaoguo
 * 创建时间:    2019/6/13 7:56 AM
 * 描述:      内存中存储数据，使用单例模式
 */
class MemoryStore private constructor() {

    private object Holder {
        internal val INSTANCE = MemoryStore()
    }

    companion object {
        internal val instance: MemoryStore
            get() = Holder.INSTANCE
    }

    val map = HashMap<String, Any>()

    fun <T> getData(key: String): T {
        @Suppress("UNCHECKED_CAST")
        return map[key] as T
    }

    fun addData(key: String, value: Any): MemoryStore {
        map[key] = value
        return this
    }

    fun <T> getData(key: Enum<*>): T {
        return getData(key.name)
    }

    fun addData(key: Enum<*>, value: Any): MemoryStore {
        addData(key.name, value)
        return this
    }
}





 
 