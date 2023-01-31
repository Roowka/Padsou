package com.example.padsou.pages

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.padsou.classes.UserController
import com.example.padsou.ui.components.addPlan.bodyAddPlan
import com.example.padsou.ui.components.addPlan.footerAddPlan
import com.example.padsou.ui.components.addPlan.headerAddPlan
import com.example.padsou.ui.components.profil.bodyProfil
import com.example.padsou.ui.components.profil.footerProfil
import com.example.padsou.ui.components.profil.headerProfil
import com.example.padsou.ui.theme.Purple1
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun Profil(navController: NavHostController){
    val userController = viewModel<UserController>()

    val currentUser = Firebase.auth.currentUser

    if (currentUser != null) {
        userController.getUser(currentUser.uid)
    }

    val user = userController.user.collectAsState().value


    Column(modifier = Modifier
        .fillMaxSize()
        .background(Purple1), verticalArrangement = Arrangement.SpaceBetween) {
        Box(modifier = Modifier.padding(top = 40.dp)){
            headerProfil()
        }
        Box(modifier = Modifier.fillMaxHeight()){
            Box(modifier = Modifier.padding(top = 30.dp)){
                bodyProfil(user)
            }
            Box(modifier = Modifier.align(Alignment.BottomEnd)){
                footerProfil(navController = navController)
            }
        }
    }
}
