package com.example.padsou.ui.components.addPlan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
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
import com.example.padsou.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun bodyAddPlan(){
    val pagerState = rememberPagerState()
    var stat by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Box(){
        Column( modifier = Modifier
            .background(WhiteBackground, shape = RoundedCornerShape(35.dp, 35.dp, 0.dp, 0.dp))
            .padding(bottom = 50.dp)) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),horizontalArrangement = Arrangement.Center){
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    activeColor = InactiveGrey,
                    inactiveColor = Color.White,
                    indicatorWidth = 25.dp,
                    indicatorHeight = 5.dp,
                    spacing = 10.dp,
                    modifier = Modifier

                )
            }

            Row(){
                HorizontalPager(count = 2, state = pagerState) { page->
                    stat = currentPage != 0
                    when(page) {

                        0 ->{
                            LazyColumn() {
                                item {
                                    Row(modifier = Modifier
                                        .padding(top = 30.dp)
                                        .padding(horizontal = 31.dp)){
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
                                        .padding(top = 30.dp)
                                        .padding(horizontal = 31.dp)){
                                        Text(text= "Description", fontWeight = FontWeight.Bold, fontFamily = FontFamily(
                                            Font(R.font.integralcf_regular)))
                                    }
                                    Row(modifier = Modifier
                                        .padding(top = 12.dp)
                                        .padding(horizontal = 29.dp)
                                        .width(313.dp)
                                    ){
                                        Input_global(inputText = "Ne soit pas trop bavard, on s'en fou, va à l'essentiel")

                                    }
                                    Row(modifier = Modifier
                                        .padding(top = 30.dp)
                                        .padding(horizontal = 29.dp)){
                                        Text(text= "Lien", fontWeight = FontWeight.Bold, fontFamily = FontFamily(
                                            Font(R.font.integralcf_regular)))
                                    }
                                    Row(modifier = Modifier
                                        .padding(top = 12.dp)
                                        .padding(horizontal = 29.dp)
                                        .width(313.dp)){
                                        Input_global(inputText = "www.lienverstonbonplan.com")
                                    }
                                    Row(modifier = Modifier
                                        .padding(top = 25.dp)
                                        .padding(horizontal = 29.dp)){
                                        Btn_global(text = "Suivant", click = {coroutineScope.launch { pagerState.animateScrollToPage(page = pagerState.currentPage + 1) }})
                                    }
                                }

                            }

                    }

                    1->{
                        Column( modifier = Modifier
                            .fillMaxSize()
                            .background(WhiteBackground, shape = RoundedCornerShape(35.dp, 35.dp, 0.dp, 0.dp)), horizontalAlignment = Alignment.CenterHorizontally) {



                            Row(modifier = Modifier.padding(top = 76.dp, bottom = 26.dp)){
                                Text(text= "Photo du bon plan", fontWeight = FontWeight.Bold, fontFamily = FontFamily(
                                    Font(R.font.integralcf_regular)))
                            }

                            Box(modifier = Modifier.background(Purple1,shape = RoundedCornerShape(15.dp)).padding(horizontal = 60.dp).height(150.dp).width(30.dp)){
                                Icon(Icons.Filled.Add,contentDescription = null, tint = Color.White, modifier = Modifier.align(
                                    Alignment.Center).size(1000.dp))

                            }

                            Row(modifier = Modifier
                                .padding(top = 135.dp)
                                .padding(horizontal = 29.dp)){
                                Btn_global(text = "Suivant", click = { /*TODO*/ })
                            }

                        }
                    }

                    }


                }
            }


        }
    }



}

fun slide(){

}


@Preview(showBackground = true)


@Composable
fun bodyAddPlanPreview() {
    PadsouTheme {
        (bodyAddPlan())
    }
}