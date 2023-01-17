package com.example.padsou.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.ui.components.login.bodyLogin
import com.example.padsou.ui.components.login.footerLogin
import com.example.padsou.ui.components.login.headerLogin
import com.example.padsou.ui.theme.GreyBackground
import com.example.padsou.ui.theme.PadsouTheme

@Composable
fun Login(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(GreyBackground)) {
        Row(modifier = Modifier.padding(top = 80.dp, bottom = 30.dp)) {
            headerLogin()
        }
        Row(modifier = Modifier.absolutePadding(bottom = 335.dp)) {
            bodyLogin()
        }
        Row() {
            footerLogin()
        }
    }
}

@Preview(showBackground = true)

@Composable
fun LoginPreview() {
    PadsouTheme {
        Login()
    }
}