package com.piyush.testlibrary

import android.content.Context
import android.widget.Toast

class Toaster{
    fun CheckToast(context: Context,message:String,duration:Int ){
         Toast.makeText(context,message,duration).show();
    }
}