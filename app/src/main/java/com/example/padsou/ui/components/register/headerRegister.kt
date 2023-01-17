package com.example.padsou.ui.components.register

import android.icu.text.Transliterator
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.padsou.R
import com.example.padsou.ui.theme.BlackTitle
import com.example.padsou.ui.theme.PadsouTheme
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun headerRegister(colorText : Color = BlackTitle ){
    Column( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Bienvenue \uD83D\uDE0E", color = colorText, fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.integralcf_regular)))

        Text(text = "Inscris-toi pour avoir les meilleurs plans étudiants !", color = colorText, fontFamily = FontFamily(Font(R.font.integralcf_regular)), textAlign = TextAlign.Center, modifier =  Modifier.width(200.dp))
    }

}

@Preview(
    showBackground = true
)

@Composable
fun headerRegisterPreview(){
    PadsouTheme {
        headerRegister()
    }
}