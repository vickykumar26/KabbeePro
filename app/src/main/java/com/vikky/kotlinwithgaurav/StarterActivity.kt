package com.vikky.kotlinwithgaurav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.vikky.kotlinwithgaurav.databinding.ActivityStarterBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StarterActivity : AppCompatActivity() {

    lateinit var binding : ActivityStarterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStarterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Use the Kotlin coroutine to delay the start of the MainActivity
        lifecycleScope.launch {
            delay(2000) // Delay for 2000 milliseconds (2 seconds)

            // Create an Intent to start the MainActivity
            val intent = Intent(this@StarterActivity, MainActivity::class.java)

            // Start the MainActivity
            startActivity(intent)

            // Finish the current SplashScreenActivity to prevent going back to it
            finish()
        }
    }
}