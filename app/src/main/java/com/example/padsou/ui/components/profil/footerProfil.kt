package com.example.padsou.ui.components.profil

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.padsou.ui.components.globals.NavBar

@Composable
fun footerProfil(navController: NavHostController){
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(){
            NavBar(navController = navController)
        }

    }
}