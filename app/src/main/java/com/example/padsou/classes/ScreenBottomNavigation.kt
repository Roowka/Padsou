package com.example.padsou.classes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.padsou.R

sealed class ScreenBottomNavigation(val route: String,val Icon: ImageVector) {
    object Home : ScreenBottomNavigation("home", Icons.Filled.Home)
    object AddPost : ScreenBottomNavigation("register", Icons.Filled.Add)
    object Profile : ScreenBottomNavigation("onboarding",Icons.Filled.Person)
}
