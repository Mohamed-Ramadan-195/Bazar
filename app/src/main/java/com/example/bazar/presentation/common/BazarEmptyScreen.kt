package com.example.bazar.presentation.common

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import com.example.bazar.R
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen (
    error: LoadState.Error? = null
) {
    var icon by remember {
        mutableIntStateOf(R.drawable.network_error)
    }

    var message by remember {
        mutableStateOf(getErrorMessage(error = error))
    }

    if (error == null) {
        icon = R.drawable.bookmark
        message = "Empty Books"
    }

    var startAnimation by remember {
        mutableStateOf(false)
    }

    val alphaAnimation by animateFloatAsState (
        targetValue = if (startAnimation) 0.5f else 0f,
        animationSpec = tween(durationMillis = 2000),
        label = ""
    )

    LaunchedEffect (key1 = true) {
        startAnimation = true
    }

    EmptyScreenContent (
        alphaAnimation = alphaAnimation,
        message = message,
        icon = icon
    )
}

@Composable
fun EmptyScreenContent (
    alphaAnimation: Float,
    message: String,
    icon: Int
) {
   Column (
       modifier = Modifier.fillMaxSize(),
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center
   ) {
       Icon (
           painter = painterResource(icon),
           contentDescription = "Empty Screen Icon",
           tint = colorResource(R.color.primary_color),
           modifier = Modifier
               .size(200.dp)
               .alpha(alphaAnimation)
       )
       Text (
           modifier = Modifier
               .padding(12.dp)
               .alpha(alphaAnimation),
           text = message,
           fontSize = 20.sp,
           fontWeight = FontWeight.Bold,
           color = colorResource(R.color.primary_color)
       )
   }
}

fun getErrorMessage (
    error: LoadState.Error?
) : String {
    return when (error?.error) {
        is SocketTimeoutException -> {
            "Server Unavailable"
        }

        is ConnectException -> {
            "Internet Unavailable"
        }

        else -> {
            "Unknown Error"
        }
    }
}