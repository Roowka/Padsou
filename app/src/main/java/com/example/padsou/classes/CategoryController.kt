package com.example.padsou.classes

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.padsou.models.CategoryModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CategoryController : ViewModel() {
    private val _categories = MutableStateFlow<List<CategoryModel>>(listOf<CategoryModel>())
    val categories = _categories.asStateFlow()

    init {
        this.getCategories()
    }

    private fun getCategories() {
        val db = Firebase.firestore

        db.collection("categories").orderBy("position").get()
            .addOnSuccessListener { result ->
                _categories.value = result.toObjects()
            }
            .addOnFailureListener { ex -> Log.e("category error :", ex.toString()) }
    }

     fun getPicturesOfCategoryWithNames(name: String, callback: (String) -> Unit){
        val storageReference = Firebase.storage.reference

        val imagesRef = storageReference.child("images/categories/")

        imagesRef.child(name).downloadUrl.addOnSuccessListener { it ->
            callback(it.toString())
        }
            .addOnFailureListener { ex -> Log.e("image error :", ex.toString()) }

    }
}