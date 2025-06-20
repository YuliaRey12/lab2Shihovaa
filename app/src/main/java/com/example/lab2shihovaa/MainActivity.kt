package com.example.lab2shihova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputA = findViewById<EditText>(R.id.inputA)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        calculateButton.setOnClickListener {
            val a = inputA.text.toString().toDoubleOrNull()
            if (a == null) {
                resultText.text = "Введите корректное число!"
                return@setOnClickListener
            }
            if (a > 7) {
                resultText.text = "Для данного значения a результат не может быть получен"
                return@setOnClickListener
            }
            var sum = 0.0
            var n = 1
            while (sum <= a) {
                sum += 1.0 / n
                n++
            }
            resultText.text = "Первое подходящее число: %.5f\nНомер этого числа (n): %d".format(sum, n - 1)
        }
    }
}