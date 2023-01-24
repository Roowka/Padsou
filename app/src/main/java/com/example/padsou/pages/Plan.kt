package com.example.padsou.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.padsou.ui.components.login.bodyLogin
import com.example.padsou.ui.components.login.footerLogin
import com.example.padsou.ui.components.login.headerLogin
import com.example.padsou.ui.components.plan.headerPlan
import com.example.padsou.ui.theme.GreyBackground
import com.example.padsou.R
import com.example.padsou.ui.components.plan.bodyPlan
import com.example.padsou.ui.components.plan.footerPlan
import com.example.padsou.ui.theme.PadsouTheme

@Composable
fun Plan(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(GreyBackground), verticalArrangement = Arrangement.SpaceBetween) {
            Column() {
                Row() {
                    headerPlan("Abonnement 1 an", "2 mois offerts", R.drawable.tacos_border)
                }
                Row(modifier = Modifier.padding(top = 31.dp)) {
                    bodyPlan("Hector", "Last chance to look at me Hector", 34, 3)
                }
            }
            Row(modifier = Modifier.padding(bottom = 30.dp)) {
                footerPlan()
            }
    }
}

@Preview(showBackground = true)

@Composable
fun PlanPreview() {
    PadsouTheme {
        Plan()
    }
}