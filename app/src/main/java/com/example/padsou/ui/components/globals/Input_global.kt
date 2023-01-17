package com.example.padsou.ui.components.globals

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.R
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.WhiteText

@Composable
fun Input_global(inputText : String){
    var text by remember { mutableStateOf(TextFieldValue(inputText)) }
    TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            textStyle = TextStyle(color = WhiteText, fontFamily = FontFamily(Font(R.font.inter_regular)))
    )

}

@Preview(showBackground = true)

@Composable
fun Input_globalPreview() {
    PadsouTheme {
        Input_global("Entrez texte...")
    }
}