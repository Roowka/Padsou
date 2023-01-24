package com.example.padsou.pages.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.padsou.ui.components.HomeHeader
import com.example.padsou.ui.components.globals.NavBar
import com.example.padsou.ui.components.home.HomeMain
import com.example.padsou.ui.theme.Purple1

@Composable
fun Home(navController: NavHostController) {
    Scaffold(
        content = {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Purple1)) {
                HomeHeader()
                HomeMain()
            }
        },
        bottomBar = { NavBar(navController)}
    )
}
