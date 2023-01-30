package com.example.padsou.classes

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.padsou.models.UserModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserController : ViewModel() {

    private val _user = MutableStateFlow<UserModel>(UserModel())
    val user = _user.asStateFlow()

    fun createUser(user :UserModel){
        val db = Firebase.firestore

        db.collection("users").add(user)
            .addOnSuccessListener { result ->
               Log.i("User ok","creation ok")
            }
            .addOnFailureListener { ex -> Log.e("category error :", ex.toString()) }
    }

    fun getUser(uid : String){
        val db = Firebase.firestore

        db.collection("users").whereEqualTo("uuid",uid).get()
            .addOnSuccessListener{ it -> it.forEach { i -> _user.value = i.toObject() }}
            .addOnFailureListener { ex -> Log.e("category error :", ex.toString()) }
    }

}