package com.example.padsou.classes

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthController : ViewModel() {

    fun login(email : String, password: String,navHostController: NavHostController){
        val auth = Firebase.auth
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Bien :", "signInWithEmail:success")
//                    val user = auth.currentUser

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Nul :", "signInWithEmail:failure", task.exception)
                }
            }
    }

    fun register(email : String, password: String,navHostController: NavHostController){
            val auth = Firebase.auth

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Bien :", "createUserWithEmail:success")
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Nul :", "createUserWithEmail:failure", task.exception)
                }
            }
    }
}