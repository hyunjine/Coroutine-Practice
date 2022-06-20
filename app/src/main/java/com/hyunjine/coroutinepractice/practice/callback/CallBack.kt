package com.hyunjine.coroutinepractice.practice.callback

import android.util.Log
import com.hyunjine.coroutinepractice.common.TAG

class CallBack {
    fun startCallBack() = fetchData({
        processData(it, { result ->
            Log.d(TAG, result)
        }, { exception ->
            Log.d(TAG, "$exception")
        })
    }, { exception ->
        Log.d(TAG, "${exception.message}")
    })

    private fun fetchData(callback: (String) -> Unit, failure: (Exception) -> Unit = { }) {
        val a = 5
        if (a < 4) callback("hello")
        else failure(Exception("error"))
    }

    private fun processData(data: String, callback: (String) -> Unit, failure: (Exception) -> Unit = { }) {
        if (data == "hello") callback(data.plus("world"))
        else failure(Exception("error"))
    }

}