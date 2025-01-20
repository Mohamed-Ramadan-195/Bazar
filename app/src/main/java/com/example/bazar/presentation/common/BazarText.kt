package com.example.bazar.presentation.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bazar.R

@Composable
fun BazarTextHeadline (
    text: String
) {
    Text (
        text = text,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.primary_text)
    )
}

@Composable
fun BazarTextTitlePrimary (
    modifier: Modifier = Modifier,
    text: String
) {
    Text (
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = colorResource(R.color.primary_text)
    )
}

@Composable
fun BazarTextTitleSecondry (
    modifier: Modifier = Modifier,
    text: String
) {
    Text (
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = colorResource(R.color.secondary_text)
    )
}

@Composable
fun BazarTextBody (
    text: String
) {
    Text (
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = colorResource(R.color.secondary_text)
    )
}