package com.example.padsou.ui.components.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.Greeting
import com.example.padsou.R
import com.example.padsou.ui.theme.BlackTitle
import com.example.padsou.ui.theme.PadsouTheme

@Composable
fun headerLogin(colorText : Color = BlackTitle){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
      Row() {
          Text(text = "Te revoilà ! \uD83D\uDD25", color = colorText, fontFamily = FontFamily(Font(R.font.integralcf_regular)), fontWeight = FontWeight.Bold)
      }
        Row(modifier = Modifier.width(200.dp)) {
            Text(text = "Reviens vite pour profiter des bons plans", color = colorText, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(R.font.inter_regular)), fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)


@Composable
fun headerLoginPreview() {
    PadsouTheme {
        headerLogin()
    }
}