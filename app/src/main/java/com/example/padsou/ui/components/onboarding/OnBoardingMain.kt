package com.example.padsou.ui.components.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.classes.Utils
import com.example.padsou.ui.theme.InactiveGrey
import com.example.padsou.ui.theme.PadsouTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import com.example.padsou.R
import com.example.padsou.models.PostModel


@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
@Composable
fun OnBoardingMain(){
    val pagerState = rememberPagerState()
    val listOfPost = listOf<PostModel>(
        PostModel("Abonnement 1 an","2 mois offert",R.drawable.basic_post,"",R.drawable.basic_logo),
        PostModel("Le grand barathon","1 verre acheté = 1 offert",R.drawable.bar_post,"",R.drawable.bar_logo),
        PostModel("Garantie appart","Pas besoin de garants",R.drawable.chambre_post,"",R.drawable.chambre_logo),
        PostModel("Giga MAXI Tacos","5€99, dépêche toi !",R.drawable.tacos_post,"",R.drawable.tacos_logo),
    )

    Column(modifier = Modifier
        .fillMaxWidth()) {

        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center){
            HorizontalPagerIndicator(
                pagerState = pagerState,
                activeColor = Color.White,
                inactiveColor = InactiveGrey,
                indicatorWidth = 25.dp,
                indicatorHeight = 5.dp,
                spacing = 10.dp,
                modifier = Modifier
                    .padding(bottom = 28.dp),
            )
        }

        Row(){
            HorizontalPager(count = 3, state = pagerState) { page->
                Box(modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(25.dp))
                    .width(250.dp)
                    .height(250.dp)
                    .padding( horizontal = Utils.PxToDp(pixels = 40f).dp)
                ) {
                    LazyVerticalGrid(cells = GridCells.Fixed(2),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalArrangement = Arrangement.SpaceEvenly
                        , modifier = Modifier.fillMaxHeight().fillMaxHeight()){
                        items(listOfPost){
                            post -> OnBoardingCardPost(post = post)
                        }
                    }
                }
            }
        }
        
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 28.dp),horizontalArrangement = Arrangement.Center){
            Text(
                text = "Accède aux 500 bons plans qu'on te propose chaque mois",
                color = Color.White,
                modifier = Modifier.width(244.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                fontWeight = FontWeight.W500
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingMainPreview(){
    PadsouTheme {
        OnBoardingMain()
    }
}