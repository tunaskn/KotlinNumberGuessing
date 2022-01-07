package com.example.kotlinnumberguessing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sonuc.*

class SonucActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc)
        val sonuc = intent.getBooleanExtra("sonuc",false)
        if(sonuc==false){
            imageViewSonuc.setImageResource(R.drawable.gameover)
            sonucText.text="LOST!"
        } else {
            buttonAgain.text = "AGAIN"
            imageViewSonuc.setImageResource(R.drawable.win)
            sonucText.text="NICE GUESS!"
        }


        buttonAgain.setOnClickListener{
            val intent = Intent(this@SonucActivity,TahminActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}