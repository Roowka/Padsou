package com.example.padsou.ui.components.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.R
import com.example.padsou.models.PostModel

@Composable
fun OnBoardingCardPost(post : PostModel){
    Card(shape = RoundedCornerShape(10.dp),
        elevation = 0.dp,
        modifier = Modifier
            .background(Color.White)
            .width(104.dp)
            .height(104.dp)) {
        Column() {
            Box(modifier = Modifier.fillMaxWidth()){
                Image(painter = painterResource(id =post.postPicture),
                    contentDescription = "test",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp)
                        .clip(RoundedCornerShape(7.dp)),
                    contentScale = ContentScale.Crop
                )

                Image(painter = painterResource(id = post.logo),
                    contentDescription = "logo",
                    modifier = Modifier.size(20.dp)
                        .offset(x = 37.dp,y = 48.dp)
                        .border(BorderStroke(2.5f.dp,Color.White), CircleShape)
                        .clip(CircleShape),
                    contentScale = ContentScale.Fit,
                )
            }


            Column(modifier = Modifier.padding(top = 15.dp)) {
                Text(text = "${post.title}", fontWeight = FontWeight.W700, fontFamily = FontFamily(Font(R.font.inter_regular)), fontSize = 10.sp)

                Text(text = "${post.description}",fontWeight = FontWeight.W500, fontFamily = FontFamily(Font(R.font.inter_regular)), fontSize = 8.sp)
            }
        }
    }
}