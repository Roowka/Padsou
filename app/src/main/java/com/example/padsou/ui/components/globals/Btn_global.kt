package com.example.padsou.ui.components.globals

import android.content.DialogInterface.OnClickListener
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.R
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.Purple500


@Composable
fun Btn_global(text : String,click: (()->Unit)? = null,color : Color = Purple500, colorText : Color = Color.White){
    Button(
        onClick = { click },
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
        Btn_global("Button text")
    }
}
