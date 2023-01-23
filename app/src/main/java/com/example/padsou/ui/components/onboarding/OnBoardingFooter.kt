package com.example.padsou.ui.components.onboarding

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.padsou.ui.components.globals.Btn_global
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.Rose1

@Composable
fun OnBoardingFooter(navController: NavHostController){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 58.dp)
    ) {
        Btn_global(text = "C'est parti", {navController.navigate("home")},Rose1)
    }
}
