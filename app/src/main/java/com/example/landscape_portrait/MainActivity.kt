package com.example.landscape_portrait

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var txt1: TextView
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById<Button>(R.id.button)
        txt1 = findViewById<TextView>(R.id.txt_Layout)

        btn.setOnClickListener {
            txt1.setText("I have been clicked")
        if (btn.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "Portrait", Toast.LENGTH_LONG).show()
            } else {
            Toast.makeText(this, "Landscape", Toast.LENGTH_LONG).show()
            }

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("saved_txt", txt1.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        txt1.setText(savedInstanceState.getString("saved_txt"))
    }
}