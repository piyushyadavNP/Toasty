package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.api.APIInterface
import com.example.myapplication.api.RetrofitClient
import com.example.myapplication.api.RetrofitClient.getInstance
import com.example.myapplication.data.totpModel
import com.google.gson.Gson
import com.piyush.testlibrary.Toaster
import com.piyush.testlibrary.time.TimeGenerator
import retrofit2.Retrofit
import java.text.Collator.getInstance
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val button =findViewById<Button>( R.id.click) as Button;
        val checkIt = Toaster();
        val time = TimeGenerator();

        button.setOnClickListener{
            checkIt.CheckToast(this,"Toh Kaise Ho Aap Log",20);
          val time =  time.getTime();
            println("TIME"+time);
            getUserList();
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getUserList() {
        println("OKAY CALLING");
        var retrofit = RetrofitClient.getInstance();
        var apiInterface = retrofit.create(APIInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val time:String = LocalDateTime.now().toString();
                val secret:String = "hello";
                val totp = totpModel(secret,time);
                val response = apiInterface.getTotp(totp)
                if (response.isSuccessful()) {
                    var json = Gson().toJson(response.body())
                    println("JSON RESPONSE"+response.body()?.time);
                    if (response.body() != null) {
                        val totpVerify = totpModel(response.body()?.secret.toString(),
                                           response.body()?.time.toString());
                        val verify = apiInterface.verifyOtp( totpVerify);
                        var json = Gson().toJson(verify.body())
                        println("JSON"+json)
                    }
                 } else {
                    Toast.makeText(
                        this@MainActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex:Exception){
                Log.e("Error",Ex.localizedMessage)
            }
        }

    }
}