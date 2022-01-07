package com.example.kotlinnumberguessing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_tahmin.*
import kotlin.random.Random

class TahminActivity : AppCompatActivity() {
    private var randomNumber = 0
    private var sayac = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tahmin)

        randomNumber= Random.nextInt(40)
        println(randomNumber)

        textViewHelp.visibility = View.VISIBLE

        buttonGuess.setOnClickListener{
            sayac=sayac -1
            val tahmin = numberEditText.text.toString().toInt()
            lastNumberText.text="LAST GUESS: $tahmin"
            if(tahmin==randomNumber){
                val intent = Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("sonuc",true)
                finish()
                startActivity(intent)
                return@setOnClickListener
            }
            if(tahmin>randomNumber){
                textViewRemainingRight.text="REMANINING GUESS: $sayac ♥"
                textViewHelp.text="DECREASE--"
            }
            if(tahmin<randomNumber){
                textViewRemainingRight.text="REMANINING GUESS: $sayac ♥"
                textViewHelp.text="INCREASE++"
            }
            if(sayac==0){
                val intent = Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("sonuc",false)
                finish()
                startActivity(intent)
            }
            numberEditText.setHint("Enter number...")
        }
    }
}