package com.example.learning.screens

import android.content.Context
import android.content.res.Configuration
import androidx.biometric.BiometricManager
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learning.R
import com.example.learning.navigation.AppScreens
import com.example.learning.ui.main.MainViewModel
import com.example.learning.ui.theme.LearningTheme
import kotlinx.coroutines.delay

private lateinit var viewModel: MainViewModel

@Composable
fun LoginScreen(navController: NavController,vViewModel: MainViewModel) {
    viewModel = vViewModel
    Scaffold {
        LearningTheme { BodyContent(navController) }
    }

    LaunchedEffect(key1 = true){
        delay(1000)
        viewModel.hasLaunch(true)
    }
}



@Composable
private fun BodyContent(navController: NavController) {
    var navigateYet by remember {
        mutableStateOf(false)
    }
    var auth by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (!auth) MaterialTheme.colors.error else MaterialTheme.colors.primary)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Tienes que logearte para acceder",
            color = if (!auth) MaterialTheme.colors.onError else MaterialTheme.colors.onPrimary,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(36.dp))
        Image(
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .clickable {
                    viewModel.hasLaunch(true)
                },
            painter = painterResource(R.drawable.pear),
            contentDescription = "foreground"
        )
    }

     viewModel.auth.observeAsState().value?.let {
         if (it and !navigateYet){
             navController.popBackStack()
             navController.navigate(
                 route = AppScreens.FirstScreen.route
             )
             auth = it
             navigateYet = true
         }
     }
}


@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
private fun PreviewTexts() {
    LearningTheme() {
        BodyContent(rememberNavController())
    }
}

