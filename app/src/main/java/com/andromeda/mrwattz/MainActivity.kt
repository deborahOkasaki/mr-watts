package com.andromeda.mrwattz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.view.Window
import android.widget.ImageButton
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Header: username display
        val username : TextView = findViewById(R.id.text_username)
        username.setText("Gabriela Macieiro")

        //Info: dias ativos
        val qntDiasAtivo : TextView = findViewById(R.id.text_diasAtivo)
        qntDiasAtivo.setText(" 31 dias!")
        //Info: recorde
        val qntDiasRecorde : TextView = findViewById(R.id.text_recorde)
        qntDiasRecorde.setText(" 32 dias ")
        //Info: missoes
        val qntMissoes : TextView = findViewById(R.id.text_missoes)
        qntMissoes.setText(" 15")

        //NAVEGAÇÃO
        val btnOpenMission : ImageButton = findViewById(R.id.btn_missions)
        btnOpenMission.setOnClickListener{
            val intent = Intent(this, MissionsActivity :: class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }

        val callToAction : Button = findViewById(R.id.btn_callToAction)
        callToAction.setOnClickListener{
            val intent = Intent(this, MissionsActivity :: class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }

        val btnOpenInventory : ImageButton = findViewById(R.id.btn_inventory)
        btnOpenInventory.setOnClickListener {
            val intent = Intent(this, InventoryActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }
    }
}
