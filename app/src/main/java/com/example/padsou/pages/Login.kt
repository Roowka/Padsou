package com.example.padsou.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.padsou.ui.components.login.bodyLogin
import com.example.padsou.ui.components.login.footerLogin
import com.example.padsou.ui.components.login.headerLogin
import com.example.padsou.ui.theme.GreyBackground
import com.example.padsou.ui.theme.PadsouTheme

@Composable
fun Login(navController: NavHostController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(GreyBackground), verticalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = Modifier.padding(top = 80.dp)) {
            Row(modifier = Modifier.padding(bottom = 30.dp)) {
                headerLogin()
            }
            Row() {
                bodyLogin(navController)
            }
        }
        Row() {
            footerLogin(navController)
        }
    }
}
