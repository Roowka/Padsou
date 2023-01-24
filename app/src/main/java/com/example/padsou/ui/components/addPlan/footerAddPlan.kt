package com.example.padsou.ui.components.addPlan

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.padsou.ui.components.globals.NavBar
import com.example.padsou.ui.theme.PadsouTheme

@Composable
fun footerAddPlan(navController: NavHostController){
    Column(modifier = Modifier.fillMaxWidth()) {
      Box(){
              NavBar(navController = navController)
      }

    }
}


