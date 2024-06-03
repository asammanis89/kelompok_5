package com.example.project179.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.project179.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    var binding: ActivityIntroBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        binding!!.startBtn.setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    this@IntroActivity,
                    MainActivity::class.java
                )
            )
        }
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
}