package com.example.padsou.ui.components.globals

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.sharp.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.InputValidation.EmailState
import com.example.padsou.R
import com.example.padsou.ui.theme.PadsouTheme

@Composable
fun Input_profil(
    value: String,
    error: String?,
    inputText: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    showPasswordIcon: Boolean = false
) {
    Column() {
        val showPassword = remember { mutableStateOf(false) }
        TextField(
            value = value,
            onValueChange = { value -> onValueChange(value) },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_regular))
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    text = "${inputText}",
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.inter_regular))
                )
            },
            keyboardOptions = keyboardOptions,
            visualTransformation =
            if (showPassword.value) {
                VisualTransformation.None
            } else {
                visualTransformation
            },
            trailingIcon = {
                if (showPasswordIcon) {
                    if (showPassword.value) {
                        IconButton(onClick = { showPassword.value = false }) {
                            Icon(Icons.Filled.Lock, contentDescription = null)
                        }
                    } else {
                        IconButton(onClick = { showPassword.value = true }) {
                            Icon(Icons.Sharp.Info, contentDescription = null)
                        }
                    }
                }
            }
        )

        error?.let { ErrorFieldProfil(it) }
    }
}

@Composable
fun ErrorFieldProfil(error: String) {
    Text(
        text = error,
        modifier = Modifier.fillMaxWidth(),
        color = Color.Red,
        fontFamily = FontFamily(Font(R.font.inter_regular))
    )
}

@Preview(showBackground = true)

@Composable
fun Input_profilPreview() {
    PadsouTheme {
        var mailState = remember { EmailState() }
        Input_profil(mailState.text, mailState.error, "Entrez texte...", {
            mailState.text = it
            mailState.validate()
        })
    }
}