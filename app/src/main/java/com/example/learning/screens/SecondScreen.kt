package com.example.learning.screens

import com.example.learning.Message
import android.content.res.Configuration
import android.icu.text.CaseMap.Title
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
import com.example.learning.ui.theme.LearningTheme

@Composable
fun SecondScreen(navController: NavController,msg:Message) {
    Scaffold(topBar = {
        TopAppBar() {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Second Screen",
                fontSize = 25.sp
            )
        }
    }) {
        LearningTheme {
            BodyContent(msg, navController)
        }
    }
}

@Composable
private fun BodyContent(message: Message, navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyImage()
        MyText(text = message.tittle, fontSize = 35, color = MaterialTheme.colors.primary)
        MyText(text = message.body, fontSize = 16, color = MaterialTheme.colors.onBackground)
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            MyText(text = "go back", fontSize = 16, color = Color.White)
        }
    }
}

@Composable
private fun MyImage() {
    Image(
        modifier = Modifier
            .size(250.dp)
            .clip(CircleShape),
        painter = painterResource(R.drawable.pear),
        contentDescription = "foreground"
    )
}

@Composable
private fun MyText(text: String, fontSize: Int, color: Color, maxLines: Int = Int.MAX_VALUE) {
    Text(
        modifier = Modifier
            .wrapContentWidth(Alignment.Start)
            .padding(top = 16.dp),
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
    LearningTheme {
        BodyContent(Message("yes","NOOOOO"), rememberNavController())
    }
}

