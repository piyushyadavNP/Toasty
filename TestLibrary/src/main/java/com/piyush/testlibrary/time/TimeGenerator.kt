package com.piyush.testlibrary.time

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
class TimeGenerator {

    fun getTime(): LocalTime? {
        val time = LocalTime.now();
        return time;
    }

}