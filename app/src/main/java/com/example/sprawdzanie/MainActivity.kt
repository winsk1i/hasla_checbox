package com.example.sprawdzanie

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.CheckBox
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val elo=findViewById<Button>(R.id.SubmitButton)
        val haslo=findViewById<EditText>(R.id.haslo)
        val hasla=findViewById<EditText>(R.id.hasla)


        elo.setOnClickListener{
            val check=findViewById<CheckBox>(R.id.takie_same)
            if(haslo.text.toString()!=hasla.text.toString()){
                check.isChecked=false
            }else{
                check.isChecked=true

                val check1=findViewById<CheckBox>(R.id.duzy)
                val duzalitera = Pattern.compile(".*[A-Z].*").matcher(haslo.text.toString()).matches() ||
                        Pattern.compile(".*[A-Z].*").matcher(hasla.text.toString()).matches()
                check1.isChecked = duzalitera

                val check2=findViewById<CheckBox>(R.id.maly)
                val malalitera = Pattern.compile(".*[a-z].*").matcher(haslo.text.toString()).matches() ||
                        Pattern.compile(".*[a-z].*").matcher(hasla.text.toString()).matches()
                check2.isChecked = malalitera

                val check3=findViewById<CheckBox>(R.id.liczba)
                val cyfra = Pattern.compile(".*[0-9].*").matcher(haslo.text.toString()).matches() ||
                        Pattern.compile(".*[0-9].*").matcher(hasla.text.toString()).matches()
                check3.isChecked = cyfra

                val check4=findViewById<CheckBox>(R.id.specjalista)
                val znakspecjalny = Pattern.compile(".*[~!@#$%^&*_+:;,.<>/?-].*").matcher(haslo.text.toString()).matches() ||
                        Pattern.compile(".*[~!@#$%^&*_+:;,.<>/?-].*").matcher(hasla.text.toString()).matches()
                check4.isChecked = znakspecjalny

            }
        }
    }
}