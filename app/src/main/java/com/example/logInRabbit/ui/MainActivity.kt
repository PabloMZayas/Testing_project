package com.example.logInRabbit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.logInRabbit.R
import com.example.logInRabbit.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}