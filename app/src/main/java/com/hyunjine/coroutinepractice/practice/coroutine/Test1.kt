package com.hyunjine.coroutinepractice.practice.coroutine

import android.util.Log
import com.hyunjine.coroutinepractice.common.TAG
import kotlinx.coroutines.*

class Test1 {
    fun startCoroutine() {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d(TAG, "startCoroutine")
            val fetchedData = fetchData()
            Log.d(TAG, "startCoroutine: $fetchedData")
//            val processedData = processData(fetchedData)
//            Log.d(TAG, "startCoroutine: $processedData")
        }
    }

    private suspend fun fetchData() {
        for (i: Int in 0..1000) {
            when (true) {
                i < 200 -> Log.d(TAG, "startCoroutine: ${i / 10} ")
                i < 400 -> Log.d(TAG, "startCoroutine: ${i / 20} ")
                i < 600 -> Log.d(TAG, "startCoroutine: ${i / 30} ")
                else -> Log.d(TAG, "startCoroutine: ${i / 40} ")
            }
        }
        delay(10L)
        "hello world"
    }

    private suspend fun processData(data: String) =
        withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
            "Gdgd"
        }
}