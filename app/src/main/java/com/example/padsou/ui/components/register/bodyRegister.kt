package com.example.padsou.ui.components.register

import android.util.Log
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.padsou.InputValidation.ConfirmPasswordState
import com.example.padsou.InputValidation.EmailState
import com.example.padsou.InputValidation.PasswordState
import com.example.padsou.R
import com.example.padsou.classes.AuthController
import com.example.padsou.ui.components.globals.Btn_global
import com.example.padsou.ui.components.globals.Input_global
import com.example.padsou.ui.theme.GreyText
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.WhiteText


@Composable
fun bodyRegister(navController: NavHostController) {

    val mailState = remember { EmailState() }
    val passwordState = remember { PasswordState() }
    var confirmPasswordState = remember { ConfirmPasswordState() }

    val authController = viewModel<AuthController>()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {

        Row(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
            Input_global(
                mailState.text,
                mailState.error,
                inputText = "Ton adresse e-mail",
                {
                    mailState.text = it
                    mailState.validate()
                },
                KeyboardOptions(keyboardType = KeyboardType.Email)
            )
        }
        Row(modifier = Modifier.padding(bottom = 12.dp)) {
            Input_global(
                passwordState.text,
                passwordState.error,
                inputText = "Ton mot de passe",
                {
                    passwordState.text = it
                    passwordState.validate()
                },
                KeyboardOptions(keyboardType = KeyboardType.Password),
                PasswordVisualTransformation()
            )
        }
        Row(modifier = Modifier.padding(bottom = 12.dp)) {
            Input_global(
                confirmPasswordState.text,
                confirmPasswordState.error,
                inputText = "Confirme ton mot de passe",
                {
                    confirmPasswordState.text = it
                    confirmPasswordState.state = passwordState.text == confirmPasswordState.text
                    confirmPasswordState.validate()
                },
                KeyboardOptions(keyboardType = KeyboardType.Password),
                PasswordVisualTransformation()
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 40.dp)
                .width(300.dp)
        ) {
            Text(
                text = "En t’inscrivant, tu acceptes les Conditions générales d’utilisation de Padsou",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = GreyText,
                fontFamily = FontFamily(Font(R.font.inter_regular))
            )
        }

        Row(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)) {
            Btn_global("Se connecter", {authController.register(mailState.text,passwordState.text,navController)}, mailState.isValid() && passwordState.isValid() && confirmPasswordState.isValid())
        }

    }


}
