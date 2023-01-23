package com.example.padsou.ui.components.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.R
import com.example.padsou.ui.components.globals.Btn_global
import com.example.padsou.ui.theme.*

@Composable
fun footerLogin(){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.padding(top = 30.dp, bottom = 30.dp)){
            Text(text = "Pas encore inscrit ?", fontFamily = FontFamily(Font(R.font.inter_regular)), modifier = Modifier.padding(end = 2.dp), fontSize = 12.sp)
            Text(text = "Allez viens !", color = Purple1, modifier = Modifier.padding(start = 2.dp), fontSize = 12.sp)
        }
    }
}

@Preview(showBackground = true)

@Composable
fun footerLoginPreview() {
    PadsouTheme {
        footerLogin()
    }
}