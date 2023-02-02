package com.example.padsou.ui.components.plan

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.padsou.R
import com.example.padsou.ui.components.globals.headerAjout
import com.example.padsou.ui.theme.PadsouTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun headerPlan(titleText: String, descText: String, imageName: String){
    Column(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp))) {
        Box(modifier = Modifier.height(240.dp)){
            Image(painter = rememberAsyncImagePainter(model = imageName),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .drawWithCache {
                        val gradient = Brush.horizontalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startX = size.width,
                            endX = -150.0F
                        )
                        onDrawWithContent {
                            drawContent()
                            drawRect(gradient, blendMode = BlendMode.Multiply)
                        }
                    }
                    .fillMaxWidth()
            )
            Box(modifier = Modifier.padding(start = 80.dp)){
                Text(titleText, fontSize = 26.sp, fontFamily = FontFamily(Font(R.font.integralcf_regular)), color = Color.White, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 100.dp))
                Text(descText, fontSize = 13.sp, fontFamily = FontFamily(Font(R.font.inter_regular)), color = Color.White, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 135.dp))
            }
        }
    }
}

@Preview(showBackground = true)

@Composable
fun headerPlanPreview() {
    PadsouTheme {
        headerPlan("Titre ici", "Desc ici", "Test")
    }
}