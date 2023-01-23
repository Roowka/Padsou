package com.example.padsou.ui.components.addPlan

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.R
import com.example.padsou.classes.Utils
import com.example.padsou.ui.components.globals.Btn_global
import com.example.padsou.ui.components.globals.Input_global
import com.example.padsou.ui.components.globals.headerAjout
import com.example.padsou.ui.components.login.headerLogin
import com.example.padsou.ui.components.onboarding.OnBoardingCardPost
import com.example.padsou.ui.theme.GreyText
import com.example.padsou.ui.theme.InactiveGrey
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.WhiteBackground
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun bodyAddPlan(){
    val pagerState = rememberPagerState()

    Column( modifier = Modifier
        .fillMaxSize()
        .background(WhiteBackground, shape = RoundedCornerShape(35.dp, 35.dp, 0.dp, 0.dp))) {

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
            HorizontalPager(count = 2, state = pagerState) { page->
                Text(text = "${page}")

            }
        }


        Row(modifier = Modifier.padding(top = 76.dp).padding(horizontal = 31.dp)){
            Text(text= "Titre", fontWeight = FontWeight.Bold, fontFamily = FontFamily(
                Font(R.font.integralcf_regular)))
        }

        Row(modifier = Modifier
            .padding(top = 12.dp)
            .padding(horizontal = 29.dp)
            .width(313.dp)){
            Input_global(inputText = "Abonnement ")
        }
        Row(modifier = Modifier
            .padding(top = 32.dp)
            .padding(horizontal = 31.dp)){
            Text(text= "Description", fontWeight = FontWeight.Bold, fontFamily = FontFamily(
                Font(R.font.integralcf_regular)))
        }
        Row(modifier = Modifier
            .padding(top = 12.dp)
            .padding(horizontal = 29.dp)
            .width(313.dp)
            ){
            Input_global(inputText = "test")
        }
        Row(modifier = Modifier.padding(top = 30.dp).padding(horizontal = 29.dp)){
            Text(text= "Lien", fontWeight = FontWeight.Bold, fontFamily = FontFamily(
                Font(R.font.integralcf_regular)))
        }
        Row(modifier = Modifier
            .padding(top = 12.dp)
            .padding(horizontal = 29.dp)
            .width(313.dp)){
            Input_global(inputText = "test")
        }
        Row(modifier = Modifier.padding(top = 32.dp).padding(horizontal = 29.dp)){
            Btn_global(text = "Suivant", click = { /*TODO*/ })
        }

    }

}


@Preview(showBackground = true)


@Composable
fun bodyAddPlanPreview() {
    PadsouTheme {
        (bodyAddPlan())
    }
}