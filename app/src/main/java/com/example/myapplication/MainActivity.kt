package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.piyush.testlibrary.Toaster

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val button =findViewById<Button>( R.id.click) as Button;
        val checkIt = Toaster();
        button.setOnClickListener{
            checkIt.CheckToast(this,"Toh Kaise Ho Aap Log",20);
        }
    }
}