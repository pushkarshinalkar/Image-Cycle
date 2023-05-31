package com.imagecycle.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.imagecycle.R
import com.imagecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            nextActButId.setOnClickListener {
                val intent = Intent(this@MainActivity, ImageLoaderActivity::class.java)
                startActivity(intent)
            }
        }
    }
}