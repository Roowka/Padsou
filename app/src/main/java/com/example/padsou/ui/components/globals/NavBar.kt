package com.example.padsou.ui.components.globals

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.padsou.classes.ScreenBottomNavigation
import com.example.padsou.ui.theme.InactiveIconColor
import com.example.padsou.ui.theme.Purple1
import com.example.padsou.ui.theme.greyNavBar

@Composable
fun NavBar(navController: NavHostController) {
    val items = listOf(
        ScreenBottomNavigation.Home,
        ScreenBottomNavigation.AddPost,
        ScreenBottomNavigation.Profile
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(78.dp)
            .background(Color.White, shape = RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp))
            //.shadow(2.dp, shape = RoundedCornerShape(25.dp,25.dp,0.dp,0.dp), clip = true)
        ,
    ) {
        BottomNavigation(
            backgroundColor = Color.Transparent, modifier = Modifier
                .height(78.dp)
                .padding(horizontal = 90.dp),
            elevation = 0.dp
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            items.forEach { item ->
                BottomNavigationItem(
                    selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                    onClick = { navController.navigate(item.route) },
                    icon = {
                        Column(
                            modifier = Modifier
                                .height(49.dp)
                                .width(49.dp)
                                .background(greyNavBar, shape = RoundedCornerShape(5.dp)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = item.Icon,
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    },
                    selectedContentColor = Purple1,
                    unselectedContentColor = InactiveIconColor
                )
            }
        }
    }
}