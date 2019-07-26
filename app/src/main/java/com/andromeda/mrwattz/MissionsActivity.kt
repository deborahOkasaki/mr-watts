package com.andromeda.mrwattz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MissionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_missions)

        val username : TextView = findViewById(R.id.text_username)
        username.setText("Gabriela Macieiro")

        //NAVEGAÇÃO
        val btnOpenMain : ImageButton = findViewById(R.id.btn_main)
        btnOpenMain.setOnClickListener{
            val intent = Intent(this, MainActivity :: class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }

        val btnOpenInventory : ImageButton = findViewById(R.id.btn_inventory)
        btnOpenInventory.setOnClickListener{
            val intent = Intent(this, InventoryActivity :: class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }
    }
}
