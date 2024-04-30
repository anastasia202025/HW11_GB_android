package com.example.homework11

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.homework11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        repository = Repository(applicationContext)

        binding.buttonSave.setOnClickListener {
            val text = binding.editTextText.text.toString()
            repository.saveText(text)
            binding.textView.text = text
            println(repository.getText())

        }

        binding.buttonClear.setOnClickListener {
            repository.clearText()
            binding.textView.text = ""
        }

        binding.textView.text = repository.getText()
        println(repository.getText())
    }
}