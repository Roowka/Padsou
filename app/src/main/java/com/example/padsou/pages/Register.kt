package com.example.padsou.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.ui.components.register.bodyRegister
import com.example.padsou.ui.components.register.footerRegister
import com.example.padsou.ui.components.register.headerRegister
import com.example.padsou.ui.theme.GreyBackground
import com.example.padsou.ui.theme.PadsouTheme

@Composable
fun Register(){
    Column(modifier = Modifier.fillMaxSize().background(GreyBackground)) {
    Row(modifier = Modifier.padding(top = 80.dp, bottom = 30.dp)) {
            headerRegister()
        }
        Row() {
            bodyRegister()
        }
        Row() {
            footerRegister()
        }
    }
}

@Preview(
    showBackground = true
)

@Composable
fun RegisterPreview(){
    PadsouTheme {
        Register()
    }
}