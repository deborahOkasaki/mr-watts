package com.andromeda.mrwattz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Header: username display
        val username : TextView = findViewById(R.id.text_username)
        username.setText("Gabriela Macieiro")

        //Info:
        val qntDiasAtivo : TextView = findViewById(R.id.text_diasAtivo)
        qntDiasAtivo.setText(" 31 dias!")

        val qntDiasRecorde : TextView = findViewById(R.id.text_recorde)
        qntDiasRecorde.setText(" 32 dias ")

        val qntMissoes : TextView = findViewById(R.id.text_missoes)
        qntMissoes.setText(" 15")

        //Watts
        val watts : ImageView = findViewById(R.id.img_watts)
        watts.setImageResource(R.drawable.avatar_1)
        var levitate = AnimationUtils.loadAnimation(this, R.anim.levitate)
        watts.startAnimation(levitate)
        levitate.setRepeatCount(Animation.INFINITE)

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
