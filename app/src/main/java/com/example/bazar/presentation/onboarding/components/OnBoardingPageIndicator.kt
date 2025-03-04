package com.example.bazar.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.bazar.ui.theme.Gray
import com.example.bazar.util.Dimen.ExtraLargeSpace
import com.example.bazar.util.Dimen.ExtraSmallSpace
import com.example.bazar.util.Dimen.MediumSpace
import com.example.bazar.util.Dimen.SmallSpace

@Composable
fun OnBoardingPageIndicator (
    modifier: Modifier = Modifier,
    pageCount: Int,
    selectedPage: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = Gray
) {
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(times = pageCount) { page ->
            Box (
                modifier = Modifier
                    .padding(horizontal = ExtraSmallSpace)
                    .height(SmallSpace)
                    .width(
                        if(page == selectedPage) ExtraLargeSpace
                        else MediumSpace
                    )
                    .clip (RoundedCornerShape(ExtraSmallSpace))
                    .background (
                        if (page == selectedPage) selectedColor
                        else unselectedColor
                    )
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun OnBoardingPageIndicatorPreview() {
    OnBoardingPageIndicator (
        pageCount = 3,
        selectedPage = 1,
    )
}