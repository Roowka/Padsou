package com.example.padsou.ui.components.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.padsou.InputValidation.EmailState
import com.example.padsou.R
import com.example.padsou.classes.CategoryController
import com.example.padsou.classes.Utils
import com.example.padsou.models.CategoryModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun HomeCategoryCard(categoryModel: CategoryModel) {
    val categoryController = viewModel<CategoryController>()
    var uriLo by remember {
        mutableStateOf("")
    }
    categoryController.getPicturesOfCategoryWithNames(categoryModel.picture.toString()) { uri ->
        uriLo = uri
    }

    val color = categoryModel.color.toString()
    Column() {
        Box(
            modifier = Modifier
                .height(57.dp)
                .width(57.dp)
                .background(Utils.getColor(color), shape = RoundedCornerShape(5.dp))
        ) {
            Image(
                painter = rememberAsyncImagePainter(uriLo),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .align(
                        Alignment.Center
                    )
                    .size(25.dp)
            )
        }
        Text(
            text = "${categoryModel.name}",
            color = Utils.getColor(color),
            modifier = Modifier
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 10.sp,
            fontFamily = FontFamily(Font(R.font.integralcf_regular))
        )
    }
}