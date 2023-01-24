package com.example.padsou.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.padsou.pages.AddPlan
import com.example.padsou.pages.Login
import com.example.padsou.pages.Register
import com.example.padsou.pages.TestPage
import com.example.padsou.pages.home.Home
import com.example.padsou.pages.onboarding.OnBoarding

@Composable
fun RoutePadsou(navController : NavHostController){
    NavHost(navController = navController, startDestination = "onboarding"){
        //marche comme les routes sur laravel -> composable(nom de la route){Composant(navController)}
        //Ajouter le navController dans son composant de page
        composable("onboarding") { OnBoarding(navController)}
        composable("register") { Register(navController) }
        composable("login") { Login(navController)}
        composable("home") { Home(navController)}
        composable("addplan"){ AddPlan(navController)}
    }
}