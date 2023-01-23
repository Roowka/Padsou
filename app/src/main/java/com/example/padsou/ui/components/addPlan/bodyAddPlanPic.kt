

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import com.example.padsou.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun bodyAddPlanPic(){
    val pagerState = rememberPagerState()

    Column( modifier = Modifier
        .fillMaxSize()
        .background(WhiteBackground, shape = RoundedCornerShape(35.dp, 35.dp, 0.dp, 0.dp)), horizontalAlignment = Alignment.CenterHorizontally) {

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

        Row(modifier = Modifier.padding(top = 76.dp, bottom = 26.dp)){
            Text(text= "Photo du bon plan", fontWeight = FontWeight.Bold, fontFamily = FontFamily(
                Font(R.font.integralcf_regular)))
        }

        Box(modifier = Modifier.background(Purple1,shape = RoundedCornerShape(15.dp)).padding(horizontal = 85.dp).height(160.dp)){
            Icon(Icons.Filled.Add,contentDescription = null, tint = Color.White, modifier = Modifier.align(
                Alignment.Center).size(36.dp))

        }

        Row(modifier = Modifier
            .padding(top = 195.dp)
            .padding(horizontal = 29.dp)){
            Btn_global(text = "Suivant", click = { /*TODO*/ })
        }

    }

}


@Preview(showBackground = true)
@Composable
fun bodyAddPlanPicPreview() {
    PadsouTheme {
        (bodyAddPlanPic())
    }
}