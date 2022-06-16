package com.hyunjine.coroutinepractice
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.hyunjine.coroutinepractice.common.TAG
import com.hyunjine.coroutinepractice.databinding.ActivityMainBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private fun setBinding() = ActivityMainBinding.inflate(layoutInflater).also {
        binding = it
        setContentView(it.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        initView()
    }
    private fun initView() = startCoroutine()

    private fun startCoroutine() {
        MainScope().launch {
            Log.d(TAG, "startCoroutine")
            val fetchedData = fetchData()
            Log.d(TAG, "startCoroutine: $fetchedData")
            val processedData = processData(fetchedData)
            Log.d(TAG, "startCoroutine: $processedData")
        }
    }

    private suspend fun fetchData() = withContext(coroutineContext) {
        Thread.sleep(2000L)
        "hello world"
    }

    private suspend fun processData(data: String) = withContext(coroutineContext) {
        Thread.sleep(2000L)
        data.uppercase()
    }
}