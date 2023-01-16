package com.example.padsou.ui.components.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.example.padsou.R
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.Purple1

@Composable
fun OnBoardingHeader(){
    Column (modifier = Modifier.background(Purple1))
    {
        Text(text = "Pas de sous?".uppercase(),
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.integralcf_regular))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingHeaderPreview(){
    PadsouTheme {
        OnBoardingHeader()
    }
}