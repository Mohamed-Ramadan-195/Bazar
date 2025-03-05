package com.example.bazar.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.bazar.ui.theme.PrimaryColor
import com.example.bazar.ui.theme.SecondaryColor
import com.example.bazar.util.Dimen

@Composable
fun EmptyScreen (
    raw: Int,
    title: String,
    subtitle: String
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(raw))

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LottieAnimation (
            composition = composition,
            modifier = Modifier.size(250.dp)
        )
        Text (
            text = title,
            fontFamily = FontFamily.Serif,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = PrimaryColor
        )
        SpacerHeight(Dimen.ExtraSmallSpace)
        Text (
            text = subtitle,
            fontFamily = FontFamily.Serif,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = SecondaryColor
        )
    }
}