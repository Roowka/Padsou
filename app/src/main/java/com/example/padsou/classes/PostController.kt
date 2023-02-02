package com.example.padsou.classes

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.padsou.models.CategoryModel
import com.example.padsou.models.PostModel
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.tasks.await

class PostController : ViewModel() {

    init {
        this.getPosts()
    }

    private val _posts = MutableStateFlow<List<PostModel>>(listOf<PostModel>())
    val posts = _posts.asStateFlow()

    private val _post = MutableStateFlow<PostModel>(PostModel())
    val post = _post.asStateFlow()
    private val _postImg =  MutableStateFlow<String>("")
    val postImg = _postImg.asStateFlow()

     fun getPosts() {
        val db = Firebase.firestore

        db.collection("posts").get()
            .addOnSuccessListener { result ->
                _posts.value = result.toObjects()
            }
            .addOnFailureListener { ex -> Log.e("category error :", ex.toString()) }
    }

    fun getPicturesOfPostWithNames(name: String, callback: (String) -> Unit) {
        val storageReference = Firebase.storage.reference

        val imagesRef = storageReference.child("images/posts/")

        imagesRef.child(name).downloadUrl.addOnSuccessListener { it ->
            callback(it.toString())
        }
            .addOnFailureListener { ex -> Log.e("image error :", ex.toString()) }

    }

    fun addPost(post: PostModel, navController: NavHostController) {
        val db = Firebase.firestore

        db.collection("posts").add(post).addOnSuccessListener {
            Log.i("Post ok", "creation ok")
            navController.navigate("home")
        }
            .addOnFailureListener { ex -> Log.e("category error :", ex.toString()) }
    }

    fun getPost(id: String) {
        val db = Firebase.firestore

        db.collection("posts").document(id).get()
            .addOnSuccessListener { result ->
                _post.value = result.toObject(PostModel::class.java)!!
                this.getPicturesOfPostWithNames(_post.value.picturePost.toString()){
                    _postImg.value = it
                }
            }
            .addOnFailureListener { ex -> Log.e("category error :", ex.toString()) }
    }

}