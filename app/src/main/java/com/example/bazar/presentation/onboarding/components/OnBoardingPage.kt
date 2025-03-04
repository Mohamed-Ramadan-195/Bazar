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
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.bazar.R
import com.example.bazar.presentation.common.SpacerHeight
import com.example.bazar.presentation.onboarding.model.Page
import com.example.bazar.ui.theme.SecondaryColor
import com.example.bazar.util.Dimen.ExtraLargeSpace
import com.example.bazar.util.Dimen.ExtraSmallSpace
import com.example.bazar.util.Dimen.MediumSpace

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
        SpacerHeight(ExtraLargeSpace)
        Text (
            modifier = Modifier.padding(horizontal = ExtraSmallSpace),
            text = page.title,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center,
            color = Black
        )
        SpacerHeight(MediumSpace)
        Text (
            modifier = Modifier.padding(horizontal = MediumSpace),
            text = page.body,
            lineHeight = 28.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.Serif,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = SecondaryColor
        )
        SpacerHeight(ExtraLargeSpace)
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