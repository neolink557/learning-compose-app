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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import com.example.learning.ui.theme.LearningTheme

val msg = Message(
    "Hola Marge",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris id feugiat eros. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Quisque bibendum velit ut velit blandit cursus. In et iaculis enim. Nam tincidunt lectus a nisi posuere, at volutpat orci porttitor. In venenatis erat eu libero posuere, ac blandit quam luctus. Phasellus vel neque lacinia, fringilla dui ac, condimentum ipsum. Vestibulum commodo commodo felis sed pharetra. Curabitur eget molestie mi. Phasellus vel porta dolor, vel dapibus nisi. Integer consequat leo id nisi congue blandit."
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
    LazyColumn(
        Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth(1f)
    ) {
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
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = { /* Ignoring onClick */ })
            .padding(1.dp)
            .clickable {
                expanded = !expanded
            }, elevation = 10.dp, backgroundColor = MaterialTheme.colors.background
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            MyImage()
            MyTexts(message, expanded)
        }
    }

}

@Composable
fun MyTexts(message: Message, expanded: Boolean) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        MyText(text = message.tittle, 32, MaterialTheme.colors.primary, 1)
        Spacer(modifier = Modifier.height(2.dp))
        MyText(
            text = message.body,
            16,
            MaterialTheme.colors.onBackground,
            if (expanded) Int.MAX_VALUE else 1
        )
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
fun MyText(text: String, fontSize: Int, color: Color, maxLines: Int = Int.MAX_VALUE) {
    Text(
        modifier = Modifier.wrapContentWidth(Alignment.Start),
        fontSize = fontSize.sp,
        text = text,
        color = color,
        maxLines = maxLines
    )
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun PreviewTexts() {
    LearningTheme { MyView(myMessageList) }
}

