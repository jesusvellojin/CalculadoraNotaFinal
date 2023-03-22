package com.jesumoreno.notafinal.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jesumoreno.notafinal.R
import com.jesumoreno.notafinal.databinding.ActivitySplashBinding
import com.jesumoreno.notafinal.ui.signup.SignUpActivity
import kotlinx.coroutines.delay
import java.sql.Time
import java.util.Timer
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {
    private lateinit var splashBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        val wiew = splashBinding.root
        setContentView(wiew)

        val timer =Timer()
        timer.schedule(timerTask {
            val intent =Intent(this@SplashActivity, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000
        )

       // splashBinding.imageView.setOnClickListener {
       //     var intent = Intent(this, SignUpActivity::class.java)
       //     startActivity(intent)
       //  }

        Log.d("onCreate","OK")
    }

    override fun onStart() {
        super.onStart()
        Log.d("onStart","OK")
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResume","OK")
    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause","OK")
    }

    override fun onStop() {
        super.onStop()
        Log.d("onStop","OK")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("onRestart","OK")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroy","OK")
    }
}