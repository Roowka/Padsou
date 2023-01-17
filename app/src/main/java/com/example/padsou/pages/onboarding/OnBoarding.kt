package com.example.padsou.pages.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.padsou.ui.components.onboarding.OnBoardingFooter
import com.example.padsou.ui.components.onboarding.OnBoardingHeader
import com.example.padsou.ui.components.onboarding.OnBoardingMain
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.Purple1

@Composable
fun OnBoarding() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple1),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        OnBoardingHeader()
        OnBoardingMain()
        OnBoardingFooter()
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingPreview() {
    PadsouTheme {
        OnBoarding()
    }
}