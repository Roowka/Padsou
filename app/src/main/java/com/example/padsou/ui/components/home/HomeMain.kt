package com.example.padsou.ui.components.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.R
import com.example.padsou.models.PostModel
import com.example.padsou.ui.theme.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeMain() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBackground, shape = RoundedCornerShape(35.dp, 35.dp, 0.dp, 0.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Box(
                    modifier = Modifier
                        .height(57.dp)
                        .width(57.dp)
                        .background(colorBox1, shape = RoundedCornerShape(5.dp))
                ){
                    Image(painter = painterResource(id = R.drawable.bag_logo), contentDescription = null, contentScale = ContentScale.Fit, modifier =Modifier.align(
                        Alignment.Center).size(25.dp))
                }
                Text(
                    text = "Courses",
                    color = colorBox1,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.integralcf_regular))
                )
            }

            Column() {
                Box(
                    modifier = Modifier
                        .height(57.dp)
                        .width(57.dp)
                        .background(colorBox2, shape = RoundedCornerShape(5.dp))
                ){
                    Image(painter = painterResource(id = R.drawable.sport_logo), contentDescription = null, contentScale = ContentScale.Fit, modifier =Modifier.align(
                        Alignment.Center).size(25.dp))
                }
                Text(
                    text = "Sports",
                    color = colorBox2,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.integralcf_regular))
                )
            }

            Column() {
                Box(
                    modifier = Modifier
                        .height(57.dp)
                        .width(57.dp)
                        .background(colorBox3, shape = RoundedCornerShape(5.dp))
                ){
                    Image(painter = painterResource(id = R.drawable.train_logo), contentDescription = null, contentScale = ContentScale.Fit, modifier =Modifier.align(
                        Alignment.Center).size(25.dp))
                }
                Text(
                    text = "Trains",
                    color = colorBox3,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.integralcf_regular))
                )
            }

            Column() {
                Box(
                    modifier = Modifier
                        .height(57.dp)
                        .width(57.dp)
                        .background(colorBox4, shape = RoundedCornerShape(5.dp))
                ){
                    Image(painter = painterResource(id = R.drawable.soiree_logo), contentDescription = null, contentScale = ContentScale.Fit
                        , modifier =Modifier.align(
                        Alignment.Center).size(25.dp))
                }
                Text(
                    text = "Soirées",
                    color = colorBox4,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.integralcf_regular))
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
                .padding(top = 39.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Les plans du moments",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.integralcf_regular))
            )
            Text(
                text = "Voir tout",
                fontWeight = FontWeight.W700,
                color = Rouge1,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter_regular))
            )
        }

        val listOfPost = listOf<PostModel>(
            PostModel(
                "Abonnement 1 an", "2 mois offert",
                R.drawable.basic_post,
                R.drawable.basic_logo
            ),
            PostModel(
                "Le grand barathon", "1 verre acheté = 1 offert",
                R.drawable.bar_post,
                R.drawable.bar_logo
            ),
            PostModel(
                "Garantie appart", "Pas besoin de garants",
                R.drawable.chambre_post,
                R.drawable.chambre_logo
            ),
            PostModel(
                "Giga MAXI Tacos", "5€99, dépêche toi !",
                R.drawable.tacos_post,
                R.drawable.tacos_logo
            ),
            PostModel(
                "Abonnement 1 an", "2 mois offert",
                R.drawable.basic_post,
                R.drawable.basic_logo
            ),
            PostModel(
                "Le grand barathon", "1 verre acheté = 1 offert",
                R.drawable.bar_post,
                R.drawable.bar_logo
            ),
        )

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(11.dp),
            modifier = Modifier.padding(horizontal = 33.dp, vertical = 22.dp),
        ) {
            items(listOfPost) { post ->
                HeadercardPost(post = post)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeHeaderPreview() {
    PadsouTheme() {
        HomeMain()
    }
}