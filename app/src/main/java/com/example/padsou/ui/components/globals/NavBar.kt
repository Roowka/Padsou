package com.example.padsou.ui.components.globals

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.padsou.classes.ScreenBottomNavigation

@Composable
fun NavBar(navController: NavHostController) {
    val items = listOf(
        ScreenBottomNavigation.Home,
        ScreenBottomNavigation.AddPost,
        ScreenBottomNavigation.Profile
    )

    BottomNavigation(
        backgroundColor = Color.White, modifier = Modifier
            .height(78.dp)
            .clip(
                RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp)
            )
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { item ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == item.route} == true,
                onClick = { navController.navigate(item.route) },
                icon = { Icon(imageVector = item.Icon, contentDescription = null) },
                modifier = Modifier.offset(y = -5.dp)
            )
        }
    }
}