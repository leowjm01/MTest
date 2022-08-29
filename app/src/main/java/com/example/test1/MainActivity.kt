package com.example.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var textView: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //spinner
        spinner = findViewById(R.id.age)
        ArrayAdapter.createFromResource(this,R.array.Age,android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        //calculate button
     val calButton = findViewById<Button>(R.id.calculate)
         calButton.setOnClickListener { calculate(it) }

        //reset button
        val resButton = findViewById<Button>(R.id.reset)
        resButton.setOnClickListener { reset(it) }
    }

    private fun calculate(view: View){
        radioButton = findViewById(R.id.Male)
        textView = findViewById(R.id.calorie)

            if(radioButton.isChecked){
                    when(spinner.selectedItemPosition){
                       0 -> textView.text = "2400 - 3000 calories"
                       1 -> textView.text = "2200 - 3000 calories"
                        2 -> textView.text = "2000 - 3000 calories"
                    }
            }else{
                if(spinner.selectedItemPosition == 0){
                    textView.text = "2000 - 2400 calories"
                }else if(spinner.selectedItemPosition == 1){
                    textView.text = "1800 - 2200 calories"
                }else{
                    textView.text = "1600 - 2000 calories"
                }
            }
        }

    private fun reset(view: View){
        textView = findViewById(R.id.calorie)

        textView.text = null

    }

    }


