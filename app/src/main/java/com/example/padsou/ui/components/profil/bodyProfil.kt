package com.example.padsou.ui.components.profil

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.padsou.InputValidation.EmailState
import com.example.padsou.InputValidation.PasswordState
import com.example.padsou.R
import com.example.padsou.classes.UserController
import com.example.padsou.models.UserModel
import com.example.padsou.ui.components.globals.Btn_global
import com.example.padsou.ui.components.globals.Input_global
import com.example.padsou.ui.components.globals.Input_profil
import com.example.padsou.ui.theme.PadsouTheme
import com.example.padsou.ui.theme.Purple1
import com.example.padsou.ui.theme.WhiteBackground
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun bodyProfil(user: UserModel) {
    if (user.id_doc != "") {
        val currentUser = Firebase.auth.currentUser
        val userController = viewModel<UserController>()


        var pseudo by remember {
            mutableStateOf(user.pseudo)
        }

        val emailState = remember { EmailState() }
        if (currentUser != null) {
            emailState.text = currentUser.email.toString()
        }

        val passwordState = remember { PasswordState() }
        passwordState.text = user.password


        Box() {
            Column(
                modifier = Modifier
                    .background(
                        WhiteBackground,
                        shape = RoundedCornerShape(35.dp, 35.dp, 0.dp, 0.dp)
                    )
                    .fillMaxHeight()
                    .padding(bottom = 20.dp)
            ) {


                Row() {

                    LazyColumn(verticalArrangement = Arrangement.SpaceEvenly) {
                        item {
                            Column() {
                                Row(
                                    modifier = Modifier
                                        .padding(top = 25.dp)
                                        .padding(horizontal = 31.dp)
                                ) {
                                    Text(
                                        text = "Mon pseudo",
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
                                    Input_profil(pseudo, null, inputText = " ", { pseudo = it })
                                }
                            }

                            Column() {
                                Row(
                                    modifier = Modifier
                                        .padding(top = 30.dp)
                                        .padding(horizontal = 31.dp)
                                ) {
                                    Text(
                                        text = "adresse e-mail",
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
                                    Input_profil(
                                        emailState.text,
                                        emailState.error,
                                        inputText = "jacky@gmail.com",
                                        {
                                            emailState.text = it
                                            emailState.validate()
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
                                        text = "Mot de passe",
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
                                    Input_profil(
                                        passwordState.text,
                                        passwordState.error,
                                        inputText = "Mot de passe",
                                        {
                                            passwordState.text = it
                                            passwordState.validate()
                                        },
                                        KeyboardOptions(keyboardType = KeyboardType.Password),
                                        PasswordVisualTransformation(),
                                        true
                                    )
                                }
                            }
                            Row(
                                modifier = Modifier
                                    .padding(top = 100.dp)
                                    .padding(horizontal = 29.dp)
                            ) {
                                Btn_global(
                                    text = "ENREGISTRER",
                                    click = {
                                        userController.updateUser(
                                            user.id_doc,
                                            pseudo,
                                            emailState.text,
                                            passwordState.text
                                        )
                                    },
                                    enable = passwordState.isValid() && emailState.isValid()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
