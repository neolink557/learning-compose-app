package com.example.learning

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import com.example.learning.ui.theme.LearningTheme

val msg = Message(
    "Hola Marge",
    "Este es mi primer uso de compose"
)
val myMessageList = listOf(
    msg,
    msg,
    msg,
    msg,
    msg,
    msg,
    msg,
    msg,
    msg,
    msg,
    msg,
    msg,
    msg,
    msg,
    msg,
    msg,
    msg,
    msg,

    )

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningTheme { MyView(myMessageList) }
        }
    }
}


@Composable
fun MyView(messages: List<Message>) {
        LazyColumn {
            items(messages) { message ->
                MyMessageLayout(
                    message
                )
            }
        }
}

@Composable
fun MyMessageLayout(message: Message) {
    MyRows(message)
}

@Composable
fun MyRows(message: Message) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = { /* Ignoring onClick */ })
            .padding(1.dp), elevation = 10.dp, backgroundColor = MaterialTheme.colors.background
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            MyImage()
            MyTexts(message)
        }
    }

}

@Composable
fun MyTexts(message: Message) {
    Column(modifier = Modifier.padding(8.dp)) {
        MyText(text = message.tittle, 32, MaterialTheme.colors.primary)
        Spacer(modifier = Modifier.height(2.dp))
        MyText(text = message.body, 16, MaterialTheme.colors.onBackground)
    }
}

@Composable
fun MyImage() {
    Image(
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape),
        painter = painterResource(R.drawable.pear),
        contentDescription = "foreground"
    )
}

@Composable
fun MyText(text: String, fontSize: Int, color: Color) {
    Text(
        modifier = Modifier.wrapContentWidth(Alignment.Start),
        fontSize = fontSize.sp,
        text = text,
        color = color
    )
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun PreviewTexts() {
    MyView(myMessageList)
}

