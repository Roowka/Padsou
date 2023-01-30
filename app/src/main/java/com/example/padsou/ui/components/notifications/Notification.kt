package layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.padsou.R
import com.example.padsou.ui.theme.PadsouTheme

@Composable
fun Notification(textDesc: String){
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(){
            Box(modifier = Modifier.padding(8.dp)){
                Image(painter = painterResource(id = R.drawable.basic_logo), contentDescription = null, modifier = Modifier.width(60.dp))
            }
            Box(modifier = Modifier.padding(start = 80.dp, top = 10.dp)){
                Text("Padsou", fontWeight = FontWeight.Bold)
            }
            Box(modifier = Modifier.padding(start = 80.dp, top = 30.dp)){
                Text(textDesc)
            }
        }
    }
}

@Preview(showBackground = true)

@Composable
fun NotificationPreview() {
    PadsouTheme {
        Notification("Logan vient de s'inscrire !")
    }
}