package com.example.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.basiccalculator.databinding.ActivityMainBinding

enum class Methods {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE
}

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var method = Methods.ADD

    var total:Int = 0
    var previousNumber:Int = 0
    var currentNumber:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addButtonListener()
        subtractButtonListener()
        divideButtonListener()
        multiplyButtonListener()
        clearButtonListener()
        equalsButtonListener()
        displayTotal(total)
    }

    private fun addButtonListener() {
        binding.addButton.setOnClickListener {
            method = Methods.ADD
            previousNumber = currentNumber
            currentNumber = 0
        }
    }

    private fun subtractButtonListener() {
        binding.subtractButton.setOnClickListener {
            method = Methods.SUBTRACT
            previousNumber = currentNumber
            currentNumber = 0
        }
    }

    private fun divideButtonListener() {
        binding.divideButton.setOnClickListener {
            method = Methods.DIVIDE
            previousNumber = currentNumber
            currentNumber = 0
        }
    }

    private fun multiplyButtonListener() {
        binding.multiplyButton.setOnClickListener {
            method = Methods.MULTIPLY
            previousNumber = currentNumber
            currentNumber = 0
        }
    }

    private fun clearButtonListener() {
        binding.clearButton.setOnClickListener {
            total = 0
            currentNumber = 0
            displayTotal(total)
        }
    }

    private fun equalsButtonListener() {
        binding.equalsButton.setOnClickListener {

            if (method == Methods.ADD) {
                if (total != 0) {
                    total += previousNumber + currentNumber
                } else {
                    total =  previousNumber + currentNumber
                }
            }

            if (method == Methods.SUBTRACT) {
                if (total != 0) {
                    total -= previousNumber + currentNumber
                } else {
                    total = previousNumber - currentNumber
                }
            }

            if (method == Methods.MULTIPLY) {
                if (total != 0) {
                    total *= previousNumber + currentNumber
                } else {
                    total = previousNumber * currentNumber
                }
            }

            if (method == Methods.DIVIDE) {
                if (total != 0) {
                    total /= previousNumber + currentNumber
                } else {
                    total = previousNumber / currentNumber
                }
            }

            displayTotal(total)
            previousNumber = total
            currentNumber = 0
        }
    }

    fun onClickNumber(view: View){
        var buttonNumber: Button = findViewById(view.id)
        if (currentNumber == 0) {
            currentNumber=buttonNumber.text.toString().toInt()
        } else {
            var inString = currentNumber.toString()
            inString += buttonNumber.text.toString()
            currentNumber=inString.toInt()
        }

        displayTotal(currentNumber)
    }

    private fun displayTotal(num: Int) {
        binding.display.text=num.toString()
    }


}