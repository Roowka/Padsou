package com.example.padsou.ui.components.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.R
import com.example.padsou.ui.components.globals.Btn_global
import com.example.padsou.ui.components.globals.Input_global
import com.example.padsou.ui.theme.GreyText
import com.example.padsou.ui.theme.PadsouTheme

@Composable
fun bodyLogin(){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier
                .width(300.dp)
                .padding(bottom = 12.dp, top = 12.dp)) {
                Input_global(inputText = "Ton adresse e-mail")
            }
            Row(modifier = Modifier
                .width(300.dp)
                .padding(bottom = 12.dp)) {
                Input_global(inputText = "Ton mot de passe")
            }
            Row(modifier = Modifier.padding(bottom = 30.dp, start = 200.dp), horizontalArrangement = Arrangement.End){
                Text(text = "Mot de passe oublié ?", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = GreyText)
            }
            Row(modifier = Modifier
                .width(300.dp)
                .padding(bottom = 12.dp)) {
                Btn_global(text = "Se connecter")
            }
    }
}

@Preview(showBackground = true)


@Composable
fun bodyLoginPreview() {
    PadsouTheme {
        bodyLogin()
    }
}