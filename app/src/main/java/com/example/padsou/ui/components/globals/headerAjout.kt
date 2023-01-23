package com.example.padsou.ui.components.globals

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.R
import com.example.padsou.ui.components.login.headerLogin
import com.example.padsou.ui.theme.GreyBackground
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.Purple1

@Composable
fun headerAjout(){
    Column( modifier = Modifier.fillMaxWidth()) {
        Text(text = "Ajouter", color = Color.White,fontSize = 26.sp , fontWeight = FontWeight.Bold, fontFamily = FontFamily(
            Font(R.font.integralcf_regular)
        ))
        Text(text = "Un bon plan pour en faire profiter les autres", color = Color.White,fontSize = 18.sp, fontFamily = FontFamily(Font(R.font.inter_regular)), modifier =  Modifier.width(230.dp))
    }
}

@Preview(showBackground = true)

@Composable
fun headerLoginPreview() {
    PadsouTheme {
        headerAjout()
    }
}