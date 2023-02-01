package com.example.padsou.models

import com.google.firebase.firestore.DocumentId

data class PostModel(@DocumentId val id_post:String = "", val title : String? = "", val description : String? = "", val picturePost : String? = "", val link: String?= "", val logo : String? = ""){}
