package com.andromeda.mrwattz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username : TextView = findViewById(R.id.text_username)
        username.setText("Gabriela Macieiro")

        val qntDiasAtivo : TextView = findViewById(R.id.text_diasAtivo)
        qntDiasAtivo.setText(" 31 dias")


        //NAVEGAÇÃO
        val btnOpenMission : ImageButton = findViewById(R.id.btn_missions)
        btnOpenMission.setOnClickListener{
            val intent = Intent(this, MissionsActivity :: class.java)
            startActivity(intent)
        }

        val callToAction : Button = findViewById(R.id.btn_callToAction)
        callToAction.setOnClickListener{
            val intent = Intent(this, MissionsActivity :: class.java)
            startActivity(intent)
        }

        val btnOpenInventory : ImageButton = findViewById(R.id.btn_inventory)
        btnOpenInventory.setOnClickListener{
            val intent = Intent(this, InventoryActivity :: class.java)
            startActivity(intent)
        }
    }
}
