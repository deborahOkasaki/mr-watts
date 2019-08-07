package com.andromeda.mrwattz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class LoginActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()
    lateinit var user:User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameInput: EditText = findViewById(R.id.input_username)
        val passwordInput: EditText = findViewById(R.id.input_password)
        val login: Button = findViewById(R.id.btn_login)

        //Get info for authentication
        login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            authenticateUser(usernameInput, passwordInput)
        }
    }

    private fun authenticateUser(usernameInput: EditText, passwordInput: EditText) {
        val username = usernameInput.text.toString().trim()
        val password = passwordInput.text.toString().trim()

        if (username.isEmpty()) {
            usernameInput.error = "Por favor, insira o seu email"
        }
        if (password.isEmpty()) {
            passwordInput.error = "Por favor, insira a sua senha"
        }

        val userRef = db.collection("users")
        val userQuery = userRef.whereEqualTo("email", username).whereEqualTo("password", password)
            .get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        user = document.toObject(User::class.java)
                        if(user!!.email.isEmpty() && user!!.password.isEmpty()){
                            usernameInput.error = "Por favor, verifique o seu email"
                            passwordInput.error = "Por favor, verifique a sua senha"
                        } else{
                            //Saving user to the shared preferences
                            var userPersistence = this.getSharedPreferences("user", Context.MODE_PRIVATE)
                            var editor = userPersistence.edit()
                            editor.putString("id", user.id)
                            editor.putString("name", user.name)
                            editor.putString("lastAccessDt", user.lastAccessDt)
                            editor.putInt("points", user.points)
                            editor.apply()

                            //Navigating to main screen
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                        }
                    }
                } else{
                    usernameInput.error = "Por favor, verifique o seu email"
                    passwordInput.error = "Por favor, verifique a sua senha"
                }
            }


    }
}
