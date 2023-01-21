package com.example.padsou.pages.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.padsou.ui.components.HomeHeader
import com.example.padsou.ui.components.home.HomeMain
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.Purple1

@Composable
fun Home() {
    Scaffold(
        content = {
            Column(Modifier.fillMaxSize().background(Purple1)) {
                HomeHeader()
                HomeMain()
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    PadsouTheme {
        Home()
    }
}