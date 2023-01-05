package com.example.learning

import android.content.res.Configuration
import android.content.res.Resources
import android.content.res.Resources.Theme
import android.graphics.fonts.Font
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learning.ui.theme.LearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningTheme {
                Box(modifier = Modifier.background(MaterialTheme.colors.background).fillMaxWidth(1.toFloat()).fillMaxHeight(1.toFloat())) {
                    MyRows()
                }
            }
        }
    }
}


@Composable
fun MyRows() {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = { /* Ignoring onClick */ })
            .padding(1.dp),
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            MyImage()
            MyTexts()
        }
    }

}

@Composable
fun MyTexts() {
    Column(modifier = Modifier.padding(8.dp)) {
        MyText(text = "Hola Marge", 32, MaterialTheme.colors.primary)
        Spacer(modifier = Modifier.height(2.dp))
        MyText(text = "Este es mi primer uso de compose", 16, MaterialTheme.colors.onBackground)
    }
}

@Composable
fun MyImage() {
    Image(
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape),
        painter = painterResource(R.drawable.bear),
        contentDescription = "foreground"
    )
}

@Composable
fun MyText(text: String, fontSize: Int,color:Color) {
    Text(
        modifier = Modifier.wrapContentWidth(Alignment.Start),
        fontSize = fontSize.sp,
        text = text,
        color = color
    )
}

@Preview()
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewTexts() {
    LearningTheme {
        Box(modifier = Modifier.background(MaterialTheme.colors.background).fillMaxWidth(1.toFloat()).fillMaxHeight(1.toFloat())) {
            MyRows()
        }
    }
}

