package com.example.padsou.ui.components.profil

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padsou.R
import com.example.padsou.ui.components.addPlan.headerAddPlan
import com.example.padsou.ui.components.globals.headerAjout
import com.example.padsou.ui.theme.PadsouTheme

@Composable
fun headerProfil(){

    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 33.dp)) {

        Column( modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center)
        {

        Text(text = "Mon Profil", color = Color.White,fontSize = 26.sp , fontWeight = FontWeight.Bold, fontFamily = FontFamily(
            Font(R.font.integralcf_regular)
        )
        )
        Text(text = "Modifie tes infos affichées aux autres sur l’app", color = Color.White,fontSize = 18.sp, fontFamily = FontFamily(
            Font(R.font.inter_regular)
        ), modifier =  Modifier.width(230.dp))
        }

    }
}


@Preview(showBackground = true)


@Composable
fun headerProfilPreview() {
    PadsouTheme {
        (headerProfil())
    }
}
