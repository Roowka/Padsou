package com.example.padsou.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.padsou.ui.components.addPlan.bodyAddPlan
import com.example.padsou.ui.components.addPlan.footerAddPlan
import com.example.padsou.ui.components.addPlan.headerAddPlan
import com.example.padsou.ui.components.profil.bodyProfil
import com.example.padsou.ui.components.profil.footerProfil
import com.example.padsou.ui.components.profil.headerProfil
import com.example.padsou.ui.theme.Purple1

@Composable
fun Profil(navController: NavHostController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Purple1), verticalArrangement = Arrangement.SpaceBetween) {
        Box(modifier = Modifier.padding(top = 40.dp).padding(bottom = 30.dp)){
            headerProfil()
        }
        Box(){
            Box(modifier = Modifier.padding(bottom = 40.dp)){
                bodyProfil()
            }
            Box(modifier = Modifier.align(Alignment.BottomEnd)){
                footerProfil(navController = navController)
            }
        }
    }
}
