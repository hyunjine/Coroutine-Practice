package com.hyunjine.coroutinepractice.practice

import android.util.Log
import com.hyunjine.coroutinepractice.common.TAG
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

class Coroutine {
    fun startCoroutine() {
        MainScope().launch {
            Log.d(TAG, "startCoroutine")
            val fetchedData = fetchData()
            Log.d(TAG, "startCoroutine: $fetchedData")
            val processedData = processData(fetchedData)
            Log.d(TAG, "startCoroutine: $processedData")
        }
    }

    private suspend fun fetchData() = withContext(Dispatchers.IO) {
        delay(2000L)
        "hello world"
    }

    private suspend fun processData(data: String) = withContext(Dispatchers.IO) {
        delay(2000L)
        data.uppercase()
    }
}