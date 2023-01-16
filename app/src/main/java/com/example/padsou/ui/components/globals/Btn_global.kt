package com.example.padsou.ui.components.globals

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.ResourceFont
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.Greeting
import com.example.padsou.R
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.Purple1
import com.example.padsou.ui.theme.Purple500


@Composable
fun Btn_global(text : String,color : Color = Purple500, colorText : Color = Color.White){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        contentPadding = PaddingValues(vertical = 20.dp),
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(text = "${text.uppercase()}", color = colorText, fontFamily = FontFamily(Font(R.font.integralcf_regular)), fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun Btn_globalPreview() {
    PadsouTheme {
        Btn_global("Test")
    }
}
