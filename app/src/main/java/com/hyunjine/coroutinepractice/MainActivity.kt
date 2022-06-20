package com.hyunjine.coroutinepractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.hyunjine.coroutinepractice.common.TAG
import com.hyunjine.coroutinepractice.databinding.ActivityMainBinding
import com.hyunjine.coroutinepractice.practice.coroutine.Test2

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
        Log.d(TAG, "일 시작")
    }
    private fun initView() = Test2().planSchedule()
}