package com.example.padsou.ui.components.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.R
import com.example.padsou.ui.components.globals.Btn_global
import com.example.padsou.ui.theme.GreyText
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.WhiteText


@Composable
fun bodyRegister(){
    Column( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "En t’inscrivant, tu acceptes les Conditions générales d’utilisation de Padsou", color = GreyText, fontFamily = FontFamily(Font(R.font.inter_regular)), modifier = Modifier.padding(10.dp))

        PadsouTheme {
            Btn_global("Se connecter")
        }
    }


}

@Preview(
    showBackground = true
)

@Composable
fun bodyRegisterPreview(){
    PadsouTheme {
        bodyRegister()
    }
}