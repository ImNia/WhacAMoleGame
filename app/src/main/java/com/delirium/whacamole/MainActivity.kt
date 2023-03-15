package com.delirium.whacamole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.play_button)

        button.setOnClickListener {
            val intent = Intent(this, Game::class.java)
            startActivity(intent)
        }
    }
}