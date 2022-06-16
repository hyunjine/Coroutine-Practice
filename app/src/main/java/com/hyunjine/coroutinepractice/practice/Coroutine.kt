package com.hyunjine.coroutinepractice.practice

import android.util.Log
import com.hyunjine.coroutinepractice.common.TAG
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    private suspend fun fetchData() = withContext(coroutineContext) {
        "hello world"
    }

    private suspend fun processData(data: String) = withContext(coroutineContext) {
        data.uppercase()
    }
}