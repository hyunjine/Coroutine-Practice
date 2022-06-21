package com.hyunjine.coroutinepractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.hyunjine.coroutinepractice.common.TAG
import com.hyunjine.coroutinepractice.databinding.ActivityMainBinding
import com.hyunjine.coroutinepractice.practice.coroutine.Test2
import io.reactivex.rxjava3.core.Observable

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val arrayList: ArrayList<String> = arrayListOf("가", "나", "다")

    private fun setBinding() = ActivityMainBinding.inflate(layoutInflater).also {
        binding = it
        setContentView(it.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        startObservable().doOnSubscribe {
            Log.d(TAG, "start")
        }.doOnComplete {
            Log.d(TAG, "finish")
        }.doOnError {
            Log.d(TAG, "onCreate: ${it.message}")
        }.subscribe {
            Log.d(TAG, "$it")
        }
    }
    private fun startObservable(): Observable<Int> =
        Observable.just(1, 2, 3, 2).map {
            if (it > 2) throw Exception("하이")
            else it
        }
    private fun startCoroutine() = Test2().planSchedule()
}