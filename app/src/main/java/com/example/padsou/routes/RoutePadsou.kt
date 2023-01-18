package com.example.padsou.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RoutePadsou(navController : NavHostController){
    NavHost(navController = navController, startDestination = "onboarding"){
        //marche comme les routes sur laravel -> composable(nom de la route){Composant(navController)}
        //composable("onboarding") {}
    }
}