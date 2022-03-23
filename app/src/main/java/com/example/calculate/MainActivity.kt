package com.example.calculate

import android.icu.text.DecimalFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var a = ""
    var num1 = ""
    var number = true
    var check = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button17.setOnClickListener {
            if (number)
                textView.text = formatDecimal("${textView.text}0")
            else {
                textView.text = "0"
                number = true
            }
        }
        button13.setOnClickListener {
            if (number)
                textView.text = formatDecimal("${textView.text}1")
            else {
                textView.text = "1"
                number = true
            }
        }
        button14.setOnClickListener {
            if (number)
                textView.text = formatDecimal("${textView.text}2")
            else {
                textView.text = "2"
                number = true
            }
        }
        button15.setOnClickListener {
            if (number)
                textView.text = formatDecimal("${textView.text}3")
            else {
                textView.text = "3"
                number = true
            }
        }
        button9.setOnClickListener {
            if (number)
                textView.text = formatDecimal("${textView.text}4")
            else {
                textView.text = "4"
                number = true
            }
        }
        button10.setOnClickListener {
            if (number)
                textView.text = formatDecimal("${textView.text}5")
            else {
                textView.text = "5"
                number = true
            }
        }
        button11.setOnClickListener {
            if (number)
                textView.text = formatDecimal("${textView.text}6")
            else {
                textView.text = "6"
                number = true
            }
        }
        button5.setOnClickListener {
            if (number)
                textView.text = formatDecimal("${textView.text}7")
            else {
                textView.text = "7"
                number = true
            }
        }
        button6.setOnClickListener {
            if (number)
                textView.text = formatDecimal("${textView.text}8")
            else {
                textView.text = "8"
                number = true
            }
        }
        button7.setOnClickListener {
            if (number)
                textView.text = formatDecimal("${textView.text}9")
            else {
                textView.text = "9"
                number = true
            }
        }
        button16.setOnClickListener {
            a = "+"
            if (a != "" && num1 == "") {
                num1 = textView.text.toString()
            }
            if (check) {
                compute()
                num1 = textView.text.toString()
            }
            check = true
            number = false
        }
        button12.setOnClickListener {
            a = "-"
            if (a != "" && num1 == "") {
                num1 = textView.text.toString()
            }
            if (check) {
                compute()
                num1 = textView.text.toString()
            }
            check = true
            number = false
        }
        button8.setOnClickListener {
            a = "*"
            if (a != "" && num1 == "") {
                num1 = textView.text.toString()
            }
            if (check) {
                compute()
                num1 = textView.text.toString()
            }
            check = true
            number = false
        }
        button4.setOnClickListener {
            a = "/"
            if (a != "" && num1 == "") {
                num1 = textView.text.toString()
            }
            if (check) {
                compute()
                num1 = textView.text.toString()
            }
            check = true
            number = false
        }
        button3.setOnClickListener {
            a = "%"
            if (a != "" && num1 == "") {
                num1 = textView.text.toString()
            }
            if (check) {
                compute()
                num1 = textView.text.toString()
            }
            check = true
            number = false
        }
        button.setOnClickListener {
            a = ""
            num1 = ""
            number = true
            textView.text = "0"
            check = false
        }
        button2.setOnClickListener {
            textView.text = textView.text.toString().dropLast(1).ifEmpty { "0" }
        }
        button19.setOnClickListener{
            compute ()
            a = ""
            num1 = ""
            check = false
        }
        button18.setOnClickListener {
            if (!textView.text.toString().contains(".") && textView.text.toString().isNotEmpty()) {
                textView.text = "${textView.text}."
            }
        }
    }
    private fun compute () {
        val number = textView.text.toString()
        if (a != "" && number != "") {
            if (a == "+") {
                println(num1 + number)
                textView.text =
                    formatDecimal((num1.toDouble() + number.toDouble()).toString())
            } else if (a == "-") {
                textView.text =
                    formatDecimal((num1.toDouble() - number.toDouble()).toString())
            } else if (a == "*") {
                textView.text =
                    formatDecimal((num1.toDouble() * number.toDouble()).toString())
            } else if (a == "/") {
                if (number == "0" || number == "") {
                    textView.text = "ERROR"
                    return@compute
                }
                textView.text =
                    formatDecimal((number.toDouble() / number.toDouble()).toString())
            } else if (a == "%") {
                if (number == "0" || number == "") {
                    textView.text = "ERROR"
                    return@compute
                }
                textView.text =
                    formatDecimal((number.toDouble() % num1.toDouble()).toString())
            }
        }
    }
    private fun formatDecimal(num: String): String {
        val format = DecimalFormat("0.#######");
        return format.format(num.ifEmpty { "0" }.toDouble())
    }
}