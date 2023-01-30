package com.example.padsou.classes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.padsou.R

sealed class ScreenBottomNavigation(val route: String,val Icon: ImageVector) {
    object Home : ScreenBottomNavigation("home", Icons.Filled.Home)
    object AddPost : ScreenBottomNavigation("addplan", Icons.Rounded.AddCircle)
    object Profile : ScreenBottomNavigation("profil",Icons.Filled.AccountCircle)
}
