package com.example.bazar.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazar.R
import com.example.bazar.presentation.common.BazarSpacerHeight
import com.example.bazar.presentation.onboarding.model.Page
import com.example.bazar.util.Dimen.SmallSpace

@Composable
fun OnBoardingPage (
    modifier: Modifier = Modifier,
    page: Page
) {
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            painter = painterResource(page.image),
            contentDescription = "on boarding image",
            contentScale = ContentScale.Crop
        )
        BazarSpacerHeight(24.dp)
        Text (
            modifier = Modifier.padding(start = SmallSpace),
            text = page.title,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = colorResource(R.color.primary_text)
        )
        BazarSpacerHeight(12.dp)
        Text (
            modifier = Modifier.padding(start = SmallSpace),
            text = page.body,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            color = colorResource(R.color.secondary_text)
        )
        BazarSpacerHeight(24.dp)
    }
}

@Composable
@Preview(showBackground = true)
fun OnBoardingPagePreview() {
    OnBoardingPage(
        page = Page (
            title = "Now reading books will be easier",
            body = "Discover new worlds, join a vibrant reading community. Start your reading adventure effortlessly with us.",
            image = R.drawable.onboarding1
        )
    )
}