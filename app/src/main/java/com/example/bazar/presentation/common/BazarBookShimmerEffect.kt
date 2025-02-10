package com.example.bazar.presentation.common

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.bazar.R

@Composable
fun BazarBookShimmerEffect (
    modifier: Modifier = Modifier
) {
    Column (modifier = modifier) {
        Box (
            modifier = Modifier
                .size(150.dp)
                .shimmerEffect()
        )
    }
}

fun Modifier.shimmerEffect() = composed {
    val transition = rememberInfiniteTransition(label = "")
    val alpha = transition.animateFloat (
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable (
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    ).value
    background(color = colorResource(R.color.secondary_text).copy(alpha = alpha))
}