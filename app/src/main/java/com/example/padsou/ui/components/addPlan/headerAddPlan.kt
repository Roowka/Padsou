package com.example.padsou.ui.components.addPlan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.ui.components.globals.headerAjout
import com.example.padsou.ui.theme.PadsouTheme

@Composable
fun headerAddPlan(){
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 33.dp)) {
        headerAjout()
    }

}

@Preview(showBackground = true)


@Composable
fun headerAddPlanPreview() {
    PadsouTheme {
        (headerAddPlan())
    }
}
