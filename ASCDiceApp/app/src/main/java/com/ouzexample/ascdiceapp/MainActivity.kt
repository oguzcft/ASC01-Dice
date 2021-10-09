package com.ouzexample.ascdiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDice:Button=findViewById(R.id.button)
        val imgArt:ImageView=findViewById(R.id.imageView)
        val imgArt2:ImageView=findViewById(R.id.imageView3)
        val imgResult:ImageView=findViewById(R.id.imageView4)
        val textNo:TextView=findViewById(R.id.textView)
        imgArt.setImageResource(R.drawable.dice_1)//Default image
        imgArt2.setImageResource(R.drawable.dice_6)

        fun randomNo(slide:Int):Int{//random a number execute
            return (1..slide).random()
        }
        fun imageChange(selectNo:Int,img:ImageView){
             val selectedImageNo=when (selectNo){
                     1->R.drawable.dice_1
                     2->R.drawable.dice_2
                     3->R.drawable.dice_3
                     4->R.drawable.dice_4
                     5->R.drawable.dice_5
                     else->R.drawable.dice_6
                }

            img.setImageResource(selectedImageNo)
        }

        btnDice.setOnClickListener {
            val rnd1=randomNo(6)
            val rnd2=randomNo(6)
            textNo.text = "1.dice=${rnd1.toString()}\n2.dice=${rnd2.toString()}"
            imageChange(rnd1,imgArt)
            imageChange(rnd2,imgArt2)
            if (rnd1==rnd2){
                imgResult.setImageResource(R.drawable.tik)
            }
            else  imgResult.setImageResource(R.drawable.no)

        }

    }
}