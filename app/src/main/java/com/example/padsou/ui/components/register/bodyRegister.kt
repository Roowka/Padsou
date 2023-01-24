package com.example.padsou.ui.components.register

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.padsou.R
import com.example.padsou.ui.components.addPlan.bodyAddPlan
import com.example.padsou.ui.components.globals.Btn_global
import com.example.padsou.ui.components.globals.Input_global
import com.example.padsou.ui.theme.GreyText
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.WhiteText


@Composable
fun bodyRegister(navController: NavHostController){
    Column( modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)) {

        Row(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)){
            Input_global(inputText = "Ton adresse e-mail")
        }
        Row(modifier = Modifier.padding(bottom = 12.dp)){
            Input_global(inputText = "Ton mot de passe")
        }
        Row(modifier = Modifier.padding(bottom = 12.dp)){
            Input_global(inputText = "Confirme ton mot de passe")
        }
        Row(modifier = Modifier.padding(top = 40.dp).width(300.dp)){
            Text(text = "En t’inscrivant, tu acceptes les Conditions générales d’utilisation de Padsou", fontSize = 12.sp, fontWeight = FontWeight.Bold ,color = GreyText, fontFamily = FontFamily(Font(R.font.inter_regular)))
        }

        Row(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)){
            Btn_global("Se connecter", {navController.navigate("home")} )
        }

    }


}
