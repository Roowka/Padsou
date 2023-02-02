package com.example.padsou.pages

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.padsou.ui.components.login.bodyLogin
import com.example.padsou.ui.components.login.footerLogin
import com.example.padsou.ui.components.login.headerLogin
import com.example.padsou.ui.components.plan.headerPlan
import com.example.padsou.ui.theme.GreyBackground
import com.example.padsou.R
import com.example.padsou.classes.PostController
import com.example.padsou.ui.components.plan.bodyPlan
import com.example.padsou.ui.components.plan.footerPlan
import com.example.padsou.ui.theme.PadsouTheme

@Composable
fun Plan(navController: NavHostController, id_plan: String?) {
    val postController = viewModel<PostController>()
    if (id_plan != null) {
        postController.getPost(id_plan)
    }
    val post = postController.post.collectAsState().value
    val postImg = postController.postImg.collectAsState().value


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreyBackground), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
            Row() {
                if(postImg !=""){
                    headerPlan(post.title.toString(), post.description.toString(), postImg)
                }
            }
            Row(modifier = Modifier.padding(top = 31.dp)) {
                bodyPlan("Hector", "Last chance to look at me Hector", 34, 3)
            }
        }
        Row(modifier = Modifier.padding(bottom = 30.dp)) {
            post.link?.let { footerPlan(it) }
        }
    }
}

