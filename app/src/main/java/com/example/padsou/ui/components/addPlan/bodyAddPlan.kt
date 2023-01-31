package com.example.padsou.ui.components.addPlan

import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.padsou.InputValidation.EmailState
import com.example.padsou.InputValidation.LinkState
import com.example.padsou.InputValidation.PostInfoState
import com.example.padsou.R
import com.example.padsou.classes.PostController
import com.example.padsou.models.PostModel
import com.example.padsou.ui.components.globals.Btn_global
import com.example.padsou.ui.components.globals.Input_global
import com.example.padsou.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream


@OptIn(ExperimentalPagerApi::class)
@Composable
fun bodyAddPlan(navController: NavHostController) {
    val pagerState = rememberPagerState()
    var stat by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    val titleState = remember { PostInfoState() }
    val descriptionState = remember { PostInfoState() }
    val linkState = remember { LinkState() }

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val launcher = rememberLauncherForActivityResult(
        contract =
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }


    val postController = viewModel<PostController>()

    val context = LocalContext.current

    Box() {
        Column(
            modifier = Modifier
                .background(WhiteBackground, shape = RoundedCornerShape(35.dp, 35.dp, 0.dp, 0.dp))
                .padding(bottom = 50.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp), horizontalArrangement = Arrangement.Center
            ) {
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    activeColor = Purple1,
                    inactiveColor = Color.White,
                    indicatorWidth = 46.dp,
                    indicatorHeight = 7.dp,
                    spacing = 12.dp,
                )
            }

            Row() {
                HorizontalPager(
                    count = 2,
                    state = pagerState,
                    modifier = Modifier.disabledHorizontalPointerInputScroll(stat)
                ) { page ->
                    stat = currentPage == 0
                    when (page) {

                        0 -> {
                            LazyColumn(verticalArrangement = Arrangement.SpaceEvenly) {
                                item {
                                    Column() {
                                        Row(
                                            modifier = Modifier
                                                .padding(top = 25.dp)
                                                .padding(horizontal = 31.dp)
                                        ) {
                                            Text(
                                                text = "Titre",
                                                fontWeight = FontWeight.Bold,
                                                fontFamily = FontFamily(
                                                    Font(R.font.integralcf_regular)
                                                )
                                            )
                                        }

                                        Row(
                                            modifier = Modifier
                                                .padding(top = 12.dp)
                                                .padding(horizontal = 29.dp)
                                                .width(313.dp)
                                        ) {
                                            Input_global(
                                                titleState.text,
                                                titleState.error,
                                                inputText = "Abonnement 1 an Basic-Fit ",
                                                {
                                                    titleState.text = it
                                                    titleState.validate()
                                                })
                                        }
                                    }

                                    Column() {
                                        Row(
                                            modifier = Modifier
                                                .padding(top = 30.dp)
                                                .padding(horizontal = 31.dp)
                                        ) {
                                            Text(
                                                text = "Description",
                                                fontWeight = FontWeight.Bold,
                                                fontFamily = FontFamily(
                                                    Font(R.font.integralcf_regular)
                                                )
                                            )
                                        }
                                        Row(
                                            modifier = Modifier
                                                .padding(top = 12.dp)
                                                .padding(horizontal = 29.dp)
                                                .width(313.dp)
                                        ) {
                                            Input_global(
                                                descriptionState.text,
                                                descriptionState.error,
                                                inputText = "Ne soit pas trop bavard, on s'en fou, va à l'essentiel",
                                                {
                                                    descriptionState.text = it
                                                    descriptionState.validate()
                                                })

                                        }
                                    }

                                    Column() {
                                        Row(
                                            modifier = Modifier
                                                .padding(top = 30.dp)
                                                .padding(horizontal = 29.dp)
                                        ) {
                                            Text(
                                                text = "Lien",
                                                fontWeight = FontWeight.Bold,
                                                fontFamily = FontFamily(
                                                    Font(R.font.integralcf_regular)
                                                )
                                            )
                                        }
                                        Row(
                                            modifier = Modifier
                                                .padding(top = 12.dp)
                                                .padding(horizontal = 29.dp)
                                                .width(313.dp)
                                        ) {
                                            Input_global(
                                                linkState.text,
                                                linkState.error,
                                                inputText = "www.lienverstonbonplan.com",
                                                {
                                                    linkState.text = it
                                                    linkState.validate()
                                                })
                                        }
                                    }

                                    Row(
                                        modifier = Modifier
                                            .padding(top = 35.dp)
                                            .padding(horizontal = 29.dp)
                                    ) {
                                        Btn_global(
                                            text = "Suivant",
                                            enable = titleState.isValid() && descriptionState.isValid() && linkState.isValid(),
                                            click = {
                                                coroutineScope.launch {
                                                    pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                                                }
                                            })
                                    }
                                }

                            }

                        }

                        1 -> {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        WhiteBackground,
                                        shape = RoundedCornerShape(35.dp, 35.dp, 0.dp, 0.dp)
                                    ),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceEvenly
                            ) {


                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Row(modifier = Modifier.padding(top = 40.dp, bottom = 26.dp)) {
                                        Text(
                                            text = "Photo du bon plan",
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily(
                                                Font(R.font.integralcf_regular)
                                            )
                                        )
                                    }

                                    Row(modifier = Modifier.padding(horizontal = 103.dp)) {
                                        Box(
                                            modifier = Modifier
                                                .background(
                                                    Purple1,
                                                    shape = RoundedCornerShape(15.dp)
                                                )
                                                .height(160.dp)
                                                .width(174.dp)
                                                .clickable { launcher.launch("image/*") }
                                        ) {
                                            Icon(
                                                Icons.Filled.Add,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier
                                                    .align(
                                                        Alignment.Center
                                                    )
                                                    .size(60.dp)
                                            )
                                        }
                                    }
                                }

                                Row(
                                    modifier = Modifier
                                        .padding(top = 135.dp)
                                        .padding(horizontal = 29.dp)
                                ) {
                                    Btn_global(
                                        text = "Ajouter ce bon plan",
                                        enable = imageUri !== null,
                                        click = {
                                            val bitmap = MediaStore.Images.Media.getBitmap(
                                                context.contentResolver,
                                                imageUri
                                            )
                                            val baos = ByteArrayOutputStream()
                                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
                                            val data = baos.toByteArray()

                                            val ref = Firebase.storage.reference.child(
                                                "images/posts/".plus(
                                                    titleState.text.substring(
                                                        0,
                                                        3
                                                    )
                                                )
                                            )

                                            ref.putBytes(data)
                                                .addOnSuccessListener {
                                                    val posts =
                                                        PostModel(
                                                            titleState.text,
                                                            descriptionState.text,
                                                            titleState.text.substring(0, 3),
                                                            linkState.text,
                                                            "https://firebasestorage.googleapis.com/v0/b/padsou-84958.appspot.com/o/images%2Fposts%2Flogo%2Fpadsou.png?alt=media&token=3d0b67bc-d423-4190-aaca-05ebffdfbaec"
                                                        )
                                                    postController.addPost(posts, navController)
                                                }
                                                .addOnFailureListener { ex ->
                                                    Log.e(
                                                        "oula",
                                                        ex.toString()
                                                    )
                                                }
                                        })
                                }
                            }
                        }

                    }
                }
            }
        }
    }


}

private val HorizontalScrollConsumer = object : NestedScrollConnection {
    override fun onPreScroll(available: Offset, source: NestedScrollSource) = available.copy(y = 0f)
    override suspend fun onPreFling(available: Velocity) = available.copy(y = 0f)
}


fun Modifier.disabledHorizontalPointerInputScroll(disabled: Boolean = true) =
    if (disabled) this.nestedScroll(HorizontalScrollConsumer) else this
