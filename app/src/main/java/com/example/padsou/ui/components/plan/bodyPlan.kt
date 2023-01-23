package com.example.padsou.ui.components.plan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.R
import com.example.padsou.ui.theme.GreyText
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.Purple1

@Composable
fun bodyPlan(){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.background(Color.White, shape = RoundedCornerShape(15.dp)).padding(top = 20.dp)){
            Box(modifier = Modifier.width(313.dp)){
                Box(modifier = Modifier.padding(start = 20.dp)){
                    Image(painter = painterResource(id = R.drawable.basic_logo), contentDescription = null, modifier = Modifier.width(35.dp))
                }
                Box(modifier = Modifier.padding(start = 65.dp)){
                    Text("Proposé par", color = GreyText, fontSize = 12.sp)
                    Text("Killian74", modifier = Modifier.padding(top = 17.dp), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                }
            }
            Box(modifier = Modifier.width(270.dp).padding(top = 60.dp, start = 25.dp, bottom = 20.dp)){
                Text("gdtg zygd ygdyg yzgdzygdygzygdyzgyd zdyuzg dyg qzyd zgdygyzgygygydzgy dyuqzg dhozgdyu zd gzyg", fontSize = 12.sp)
            }
        }
        Box(modifier = Modifier.padding(top = 10.dp)){
            Text("Testée par 32 galériens", fontSize = 15.sp, fontFamily = FontFamily(Font(R.font.integralcf_regular)), fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)

@Composable
fun bodyPlanPreview() {
    PadsouTheme {
        bodyPlan()
    }
}