package com.example.learning.screens

import com.example.learning.Message
import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learning.R
import com.example.learning.navigation.AppScreens
import com.example.learning.ui.theme.LearningTheme

private val msg = Message(
    "Hola Marge",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris id feugiat eros. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Quisque bibendum velit ut velit blandit cursus. In et iaculis enim. Nam tincidunt lectus a nisi posuere, at volutpat orci porttitor. In venenatis erat eu libero posuere, ac blandit quam luctus. Phasellus vel neque lacinia, fringilla dui ac, condimentum ipsum. Vestibulum commodo commodo felis sed pharetra. Curabitur eget molestie mi. Phasellus vel porta dolor, vel dapibus nisi. Integer consequat leo id nisi congue blandit."
)
private val msg2 = Message(
    "Hola Mirga",
    "this monda isn hardcoded, consectetur adipiscing elit. Mauris id feugiat eros. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Quisque bibendum velit ut velit blandit cursus. In et iaculis enim. Nam tincidunt lectus a nisi posuere, at volutpat orci porttitor. In venenatis erat eu libero posuere, ac blandit quam luctus. Phasellus vel neque lacinia, fringilla dui ac, condimentum ipsum. Vestibulum commodo commodo felis sed pharetra. Curabitur eget molestie mi. Phasellus vel porta dolor, vel dapibus nisi. Integer consequat leo id nisi congue blandit."
)

private val msg3 = Message(
    "Hola Morga",
    "that monda isnt hardn=cioded, consectetur adipiscing elit. Mauris id feugiat eros. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Quisque bibendum velit ut velit blandit cursus. In et iaculis enim. Nam tincidunt lectus a nisi posuere, at volutpat orci porttitor. In venenatis erat eu libero posuere, ac blandit quam luctus. Phasellus vel neque lacinia, fringilla dui ac, condimentum ipsum. Vestibulum commodo commodo felis sed pharetra. Curabitur eget molestie mi. Phasellus vel porta dolor, vel dapibus nisi. Integer consequat leo id nisi congue blandit."
)

private val myMessageList = listOf(
    msg,
    msg2,
    msg3,
    msg,
    msg2,
    msg3,
    msg,
    msg2,
    msg3,
    msg,
    msg2,
    msg3,
    msg,
    msg2,
    msg3,
    msg,
    msg2,
    msg3,

    )


@Composable
fun FirstScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar() {
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "First Screen",
                fontSize = 25.sp
            )
        }
    }) {
        LearningTheme { BodyContent(myMessageList, navController) }
    }
}

@Composable
private fun BodyContent(messages: List<Message>, navController: NavController) {
    LazyColumn(
        Modifier
            .fillMaxWidth(1f)
            .background(color = MaterialTheme.colors.background)
    ) {
        items(messages) { message ->
            MyMessageLayout(
                message, navController
            )
        }
    }
}

@Composable
private fun MyMessageLayout(message: Message, navController: NavController) {
    MyRows(message, navController)
}

@Composable
private fun MyRows(message: Message, navController: NavController) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(8.dp)
            .background(color = MaterialTheme.colors.background)
            .padding(1.dp)
            .clickable {
                expanded = !expanded
            }, elevation = 10.dp, backgroundColor = MaterialTheme.colors.background
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            MyImage(message, navController)
            MyTexts(message, expanded)
        }
    }

}

@Composable
private fun MyTexts(message: Message, expanded: Boolean) {
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
private fun MyImage(message: Message, navController: NavController) {
    Image(
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .clickable {
                navController.navigate(
                    route = AppScreens.SecondScreen.route + "/" +message.tittle + "/" +message.body
                )
            },
        painter = painterResource(R.drawable.pear),
        contentDescription = "foreground"
    )
}

@Composable
private fun MyText(text: String, fontSize: Int, color: Color, maxLines: Int = Int.MAX_VALUE) {
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
private fun PreviewTexts() {
    LearningTheme() {
        BodyContent(myMessageList, rememberNavController())
    }
}

