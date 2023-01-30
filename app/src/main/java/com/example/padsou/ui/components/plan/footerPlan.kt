package com.example.padsou.ui.components.plan

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.ui.components.globals.Btn_global
import com.example.padsou.ui.theme.PadsouTheme

@Composable
fun footerPlan(){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.width(313.dp)){
            Btn_global(text = "Profiter de l'offre", click = { /*TODO*/ })
        }
    }
}

@Preview(showBackground = true)

@Composable
fun footerPlanPreview() {
    PadsouTheme {
        footerPlan()
    }
}