package com.example.padsou.classes

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.padsou.models.UserModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase

class AuthController : ViewModel() {

    fun login(email: String, password: String, navHostController: NavHostController) {
        val auth = Firebase.auth
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Bien :", "signInWithEmail:success")
                    navHostController.navigate("home")
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Nul :", "signInWithEmail:failure", task.exception)
                    navHostController.navigate("login")
                }
            }
    }

    fun register(email: String, password: String, navHostController: NavHostController, userController: UserController) {
        val auth = Firebase.auth
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Bien :", "createUserWithEmail:success")
                    val user = task.result.user?.uid?.let { UserModel(it, "", "",password) }
                    if (user != null) {
                        userController.createUser(user)
                    }
                    navHostController.navigate("home")
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Nul :", "createUserWithEmail:failure", task.exception)
                    navHostController.navigate("register")
                }
            }
    }
}