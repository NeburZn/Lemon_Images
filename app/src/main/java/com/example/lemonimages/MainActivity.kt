package com.example.lemonimages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonimages.ui.theme.LemonImagesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonImagesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImagenesLimones()
                }
            }
        }
    }
}

@Composable
fun ImagenesLimones(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(210.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Text(
            text = "Lemonade",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(color = Color.Yellow)
                .fillMaxWidth()
                .padding(25.dp)
        )
        LemonImages()
    }

}

@Composable
fun LemonImages() {
    var count by remember { mutableStateOf(3) }
    val imageResource = when (count){
        1 -> R.drawable.lemon_drink
        2 -> R.drawable.lemon_restart
        3 -> R.drawable.lemon_tree
        else -> R.drawable.lemon_squeeze
    }
    val textResource = when(count){
        1 -> stringResource(R.string.limonada)
        2 -> stringResource(R.string.vaso)
        3 -> stringResource(R.string.arbol)
        else -> stringResource(R.string.limon)
    }
    var ruleta by remember { mutableStateOf((1..4).random()) }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = count.toString(),
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color(189, 254, 171))
                .clickable {
                    if (count < (4 + ruleta)) {
                        count++
                    } else {
                        ruleta = (1..4).random()
                        count = 1
                    }
                }
        )
        Text(
            text = textResource,
            color = Color.Black
        )
    }



}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonImagesTheme {
        ImagenesLimones()
    }
}