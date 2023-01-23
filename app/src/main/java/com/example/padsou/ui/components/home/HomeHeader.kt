package com.example.padsou.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.R
import com.example.padsou.ui.components.globals.Input_global
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.Purple1

@Composable
fun HomeHeader(){
    Column (
        modifier = Modifier
            .fillMaxWidth()
    ){
        Column(modifier = Modifier.padding(horizontal = 33.dp).padding(top = 58.dp)) {
            Text(
                text = "Coucou toi,",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.integralcf_regular)),
                fontSize = 26.sp
            )

            Text(text = "T'es en manque de thunes ?",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 13.dp),
                fontWeight = FontWeight.W500
            )
        }

        Row(modifier = Modifier.padding(horizontal = 33.dp).padding(top = 45.dp, bottom = 34.dp)) {
            Input_global(inputText = "Cherche un bon plan")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeHeaderPreview(){
    PadsouTheme {
        HomeHeader()
    }
}