package com.marcoscg.currencyedittextsample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.marcoscg.currencyedittextsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editText.setMaxLength(6)

        binding.button.setOnClickListener {
            Toast.makeText(this, "Value: ${binding.editText.getNumericValue()}", Toast.LENGTH_LONG).show()
        }
    }
}