package com.example.padsou.ui.components.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.padsou.models.PostModel

@Composable
fun OnBoardingCardPost(post : PostModel){
    Card(shape = RoundedCornerShape(10.dp), modifier = Modifier.background(Color.Red)) {
        Image(painter = painterResource(id = post.postPicture), contentDescription = "post picture")
    }
}