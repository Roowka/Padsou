package com.example.padsou.ui.components.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.R
import com.example.padsou.ui.theme.GreyText
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.Purple1

@Composable
fun footerRegister(){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.padding(top = 30.dp, bottom = 30.dp)){
            Text(text = "Déjà un compte ?", color = GreyText, fontSize = 12.sp, fontFamily = FontFamily(
                Font(R.font.inter_regular)
            ), textAlign = TextAlign.Center)

            Text(text = "Connecte-toi !", color = Purple1, fontSize = 12.sp,fontFamily = FontFamily(
                Font(R.font.inter_regular)
            ), textAlign = TextAlign.Center, modifier =  Modifier.clickable{  }.padding(start = 2.dp))
        }
    }




}


@Preview(
    showBackground = true
)

@Composable
fun footerRegisterPreview(){
    PadsouTheme {
        footerRegister()
    }
}