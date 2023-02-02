package com.example.padsou.models

import com.google.firebase.firestore.DocumentId

data class UserModel(@DocumentId val id_doc:String = "",val uuid: String = "", val pseudo:String = "", val pdp : String? = "", val password :String = "")
