package com.example.davaleba2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val auth = FirebaseAuth.getInstance()

        val resetButton = findViewById<Button>(R.id.resetButton)

        resetButton.setOnClickListener {
            val emailEditText = findViewById<EditText>(R.id.emailEditText)
            val email = emailEditText.text.toString()

            if(email.isEmpty()) {
                emailEditText.error = "Email address is required"
            } else {
                auth.sendPasswordResetEmail(email).addOnCompleteListener {task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Password reset email sent", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Password reset email failed to send", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }


}