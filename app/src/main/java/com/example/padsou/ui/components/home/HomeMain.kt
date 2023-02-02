package com.example.padsou.ui.components.home

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.runtime.collectAsState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.padsou.R
import com.example.padsou.classes.CategoryController
import com.example.padsou.classes.PostController
import com.example.padsou.models.CategoryModel
import com.example.padsou.models.PostModel
import com.example.padsou.ui.theme.*
import kotlinx.coroutines.flow.collect


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeMain(navController: NavHostController) {
    val categoryController = viewModel<CategoryController>()
    val postController = viewModel<PostController>()
    val listCategories: List<CategoryModel> = categoryController.categories.collectAsState().value
    val listOfPost: List<PostModel> = postController.posts.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBackground, shape = RoundedCornerShape(35.dp, 35.dp, 0.dp, 0.dp))
            .padding(bottom = 65.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            listCategories.forEach { categoryModel ->
                HomeCategoryCard(categoryModel = categoryModel)
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


        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(11.dp),
            modifier = Modifier.padding(horizontal = 33.dp, vertical = 22.dp),
        ) {
            items(listOfPost) { post ->
                HeadercardPost(post = post, navController = navController)
            }
        }

    }
}