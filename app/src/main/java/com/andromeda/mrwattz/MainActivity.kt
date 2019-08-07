package com.andromeda.mrwattz

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.joda.time.Days
import org.joda.time.LocalDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Accessing user persistent store
        var userPersistence = this.getSharedPreferences("user", Context.MODE_PRIVATE)
        val name = userPersistence.getString("name", "")
        //Header: username display
        val username : TextView = findViewById(R.id.text_username)
        username.setText(name)

        //Watts
        val hpGauge : TextView = findViewById(R.id.points)
        val points = userPersistence.getInt("points", 100)

        //-- calculating current points
        val lastAccess = userPersistence.getString("lastAccessDt", "")
        val finalPoints = points - Days.daysBetween(LocalDate.now(), LocalDate(lastAccess)).days

        //-- updating gauge value
        val pointsText :String = finalPoints.toString() + "/100"
        hpGauge.setText(pointsText)

        //--updating gauge bar
        val gaugeBar : View = findViewById(R.id.hp_gauge)
        val newWidth = (525*finalPoints*0.01).toInt()
        gaugeBar.getLayoutParams().width =  newWidth
        gaugeBar.requestLayout()

        //-- defining Watts state
        val watts : ImageView = findViewById(R.id.img_watts)
        if(finalPoints >= 80){
            watts.setImageResource(R.drawable.avatar_3)
        } else if(finalPoints >= 40 && finalPoints < 80){
            watts.setImageResource(R.drawable.avatar_2)
        } else if(finalPoints > 0 && finalPoints < 40){
            watts.setImageResource(R.drawable.avatar_1)
        } else if(finalPoints == 0){
            watts.setImageResource(R.drawable.avatar_0)
        }

        var levitate = AnimationUtils.loadAnimation(this, R.anim.levitate)
        if(finalPoints > 0) {
            watts.startAnimation(levitate)
            levitate.setRepeatCount(Animation.INFINITE)
        }

        //Info:
        //Update lastAccessDt
        val qntDiasAtivo : TextView = findViewById(R.id.text_diasAtivo)
        qntDiasAtivo.setText(" 31 dias!")

        val qntDiasRecorde : TextView = findViewById(R.id.text_recorde)
        qntDiasRecorde.setText(" 32 dias ")

        val qntMissoes : TextView = findViewById(R.id.text_missoes)
        qntMissoes.setText(" 15")

        //Check record

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
