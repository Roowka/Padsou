package com.example.padsou.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.padsou.pages.*
import com.example.padsou.pages.home.Home
import com.example.padsou.pages.onboarding.OnBoarding

@Composable
fun RoutePadsou(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "onboarding") {
        //marche comme les routes sur laravel -> composable(nom de la route){Composant(navController)}
        //Ajouter le navController dans son composant de page
        composable("onboarding") { OnBoarding(navController) }
        composable("register") { Register(navController) }
        composable("login") { Login(navController) }
        composable("home") { Home(navController) }
        composable("addplan") { AddPlan(navController) }
        composable("profil") { Profil(navController) }
        composable(
            "post/{id_post}",
            arguments = listOf(navArgument("id_post") { type = NavType.StringType })
        ){ backStackEntry -> Plan(navController,backStackEntry.arguments?.getString("id_post"))}
    }
}