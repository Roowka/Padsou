package com.example.padsou.ui.components.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.padsou.InputValidation.EmailState
import com.example.padsou.InputValidation.PasswordState
import com.example.padsou.R
import com.example.padsou.classes.AuthController
import com.example.padsou.ui.components.globals.Btn_global
import com.example.padsou.ui.components.globals.Input_global
import com.example.padsou.ui.theme.GreyText
import com.example.padsou.ui.theme.PadsouTheme

@Composable
fun bodyLogin(navController: NavHostController) {

    val mailState = remember { EmailState() }
    val passwordState = remember { PasswordState() }

    val authController = viewModel<AuthController>()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 12.dp, top = 12.dp)
        ) {
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

        Column() {
            Row(
                modifier = Modifier
                    .padding(bottom = 17.dp)
            ) {
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
            Row(
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .align(Alignment.End),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Mot de passe oublié ?",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = GreyText,
                    textAlign = TextAlign.End,
                    fontFamily = FontFamily(Font(R.font.inter_regular))
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(bottom = 12.dp)
        ) {
            Btn_global(
                text = "Se connecter",
                { authController.login(mailState.text, passwordState.text, navController) },
                mailState.isValid() && passwordState.isValid()
            )
        }
    }
}
