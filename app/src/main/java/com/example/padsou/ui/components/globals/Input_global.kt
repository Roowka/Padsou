package com.example.padsou.ui.components.globals

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.InputValidation.EmailState
import com.example.padsou.InputValidation.PasswordState
import com.example.padsou.InputValidation.TextFieldState
import com.example.padsou.R
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.WhiteText
import java.lang.Error

@Composable
fun Input_global(
    value: String,
    error: String?,
    inputText: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    Column() {
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
                    color = WhiteText,
                    fontFamily = FontFamily(Font(R.font.inter_regular))
                )
            },
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
        )

        error?.let { ErrorField(it) }
    }
}

@Composable
fun ErrorField(error: String) {
    Text(
        text = error,
        modifier = Modifier.fillMaxWidth(),
        color = Color.Red,
        fontFamily = FontFamily(Font(R.font.inter_regular))
    )
}

@Preview(showBackground = true)

@Composable
fun Input_globalPreview() {
    PadsouTheme {
        var mailState = remember { EmailState() }
        Input_global(mailState.text, mailState.error, "Entrez texte...", {
            mailState.text = it
            mailState.validate()
        })
    }
}