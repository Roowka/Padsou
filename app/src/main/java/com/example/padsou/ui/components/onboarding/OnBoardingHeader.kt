package com.example.padsou.ui.components.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.R
import com.example.padsou.classes.Utils
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.Purple1
import com.example.padsou.ui.theme.Rose1

@Composable
fun OnBoardingHeader(){
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = Utils.PxToDp(pixels = 66f).dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Text(text = "Pas de sous?".uppercase(),
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.integralcf_regular)),
            textAlign = TextAlign.Center,
            fontSize = 30.sp
        )
        Text(text = "Y'a padsou".uppercase(),
            color = Rose1,
            fontFamily = FontFamily(Font(R.font.integralcf_regular)),
            textAlign = TextAlign.Center,
            fontSize = 30.sp
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