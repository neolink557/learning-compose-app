package com.example.learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyRows()
        }
    }
}

@Composable
fun MyRows() {
    Row {
        MyImage()
        MyTexts()
    }

}

@Composable
fun MyTexts() {
    Column {
        MyText(text = "Hola Marge")
        MyText(text = "Hola margot")
    }
}

@Composable
fun MyImage() {
    Image(
        modifier = Modifier.size(150.dp),
        painter = painterResource(R.drawable.bear),
        contentDescription = "foreground"
    )
}

@Composable
fun MyText(text: String) {
    Text(
        modifier = Modifier.wrapContentWidth(Alignment.Start),
        fontSize = 35.sp,
        text = text)
}

@Preview
@Composable
fun PreviewTexts() {
    MyRows()
}
