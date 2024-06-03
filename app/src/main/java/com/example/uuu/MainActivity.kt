package com.example.uuu

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.uuu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var correctEnsver:Int = 0
    var correctNotEnsver:Int = 0

    var firstNum:Int = 0
    var secondNum:Int = 0
    var indexSign:Int = 0
    var signArray:CharArray = charArrayOf('+','-','*','/')

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickStart(view: View)
    {
        newExpresion()
    }

    fun onClickCheck(view: View)
    {
        if (signArray[indexSign] == '+')
        {
            if (firstNum + secondNum == binding.editText.text.toString().toInt())
            {
                correctEnsver++
            }
            else
            {
                correctNotEnsver++
            }
        }
        else if (signArray[indexSign] == '-')
        {
            if (firstNum - secondNum == binding.editText.text.toString().toInt())
            {
                correctEnsver++
            }
            else
            {
                correctNotEnsver++
            }
        }
        else if (signArray[indexSign] == '*')
        {
            if (firstNum * secondNum == binding.editText.text.toString().toInt())
            {
                correctEnsver++
            }
            else
            {
                correctNotEnsver++
            }
        }
        else if (signArray[indexSign] == '/')
        {
            if (firstNum / secondNum == binding.editText.text.toString().toInt())
            {
                correctEnsver++
            }
            else
            {
                correctNotEnsver++
            }
        }
        binding.txtCountCorrect.text = correctEnsver.toString()
        binding.txtCountNotCorrect.text = correctNotEnsver.toString()

        //var procent = ((correctEnsver / (correctEnsver + correctNotEnsver)) * 100)

        binding.txtAllEnsvers.text =  (correctEnsver + correctNotEnsver).toString()

        binding.txtProcent.text = ((correctEnsver.toFloat() / (correctEnsver + correctNotEnsver)) * 100f).toString() + "%"

        newExpresion()
    }

    fun newExpresion()
    {
        firstNum = (0..99).random()
        secondNum = (0..99).random()
        indexSign = (0..3).random()

        if (signArray[indexSign] == '/')
        {
            var iterarionCount:Int = 0;
            while ((firstNum % secondNum) != 0)
            {
                firstNum = (1..99).random()
                secondNum = (1..99).random()
            }
        }

        binding.txtFirstNumber.text = firstNum.toString()
        binding.txtSecopndNumber.text = secondNum.toString()
        binding.txtSign.text = signArray[indexSign].toString()
    }
}