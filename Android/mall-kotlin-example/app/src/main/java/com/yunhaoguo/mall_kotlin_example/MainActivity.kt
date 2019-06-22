package com.yunhaoguo.mall_kotlin_example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.yunhaoguo.malllibrary.net.RestClient
import com.yunhaoguo.malllibrary.net.callback.IFailure
import com.yunhaoguo.malllibrary.net.callback.ISuccess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RestClient.builder()
            .url("")
            .success(object: ISuccess {
                override fun onSuccess(response: String) {
                    Toast.makeText(baseContext, response, Toast.LENGTH_LONG).show()
                }
            })
            .failure(object: IFailure {
                override fun onFailure() {
                    Toast.makeText(baseContext, "完蛋", Toast.LENGTH_LONG).show()
                }
            })
            .build()
            .get()
    }
}
