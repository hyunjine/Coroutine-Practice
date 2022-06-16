package com.hyunjine.coroutinepractice
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.hyunjine.coroutinepractice.common.TAG
import com.hyunjine.coroutinepractice.databinding.ActivityMainBinding
import com.hyunjine.coroutinepractice.practice.Coroutine
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
    private fun initView() {
        Coroutine().startCoroutine()
    }
}