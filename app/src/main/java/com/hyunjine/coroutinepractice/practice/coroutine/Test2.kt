package com.hyunjine.coroutinepractice.practice.coroutine

import android.util.Log
import com.hyunjine.coroutinepractice.common.TAG
import kotlinx.coroutines.*

class Test2 {
    companion object { const val DELAY: Long = 1000L }

    fun planSchedule() = CoroutineScope(Dispatchers.IO).launch {
        Log.d(TAG, "현진이의 출근길")
        Log.d(TAG, "----------")
        Log.d(TAG, "눈을 뜬다")
        launch {
            shower()
            morning()
            bus()
            arrive()
        }
        delay(DELAY)
        youtube("유튜브를 본다 1")
        delay(DELAY)
        youtube("유튜브를 본다 2")
        delay(DELAY)
        youtube("유튜브를 본다 3")
    }

    private fun youtube(str: String) = Log.d(TAG, "Main: $str")

    private suspend fun shower() {
        Log.d(TAG, "Coroutine: 샤워 중")
        delay(DELAY)
    }
    private suspend fun morning() {
        Log.d(TAG, "Coroutine: 아침 먹는 중")
        delay(DELAY)
    }
    private suspend fun bus() {
        Log.d(TAG, "Coroutine: 버스타고 출근 중")
        delay(DELAY)
    }
    private suspend fun arrive() {
        Log.d(TAG, "Coroutine: 회사 도착")
        delay(DELAY)
    }
}