package com.example.bazar.presentation.onboarding.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.bazar.presentation.onboarding.components.OnBoardingPage
import com.example.bazar.presentation.onboarding.components.OnBoardingPageIndicator
import com.example.bazar.presentation.onboarding.model.pages
import com.example.bazar.ui.theme.PrimaryColor
import com.example.bazar.util.Dimen
import com.example.bazar.util.Dimen.MediumSpace
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen (
    onBoardingEvent: (OnBoardingEvent) -> Unit
) {
    Column (modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0) { pages.size }
        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }
        Spacer(modifier = Modifier.weight(1f))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumSpace)
                .navigationBarsPadding(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OnBoardingPageIndicator (
                pageCount = pages.size,
                selectedPage = pagerState.currentPage
            )
            val scope = rememberCoroutineScope()
            if (pagerState.currentPage == 2) {
                Button(
                    onClick = {
                        scope.launch {
                            onBoardingEvent(OnBoardingEvent.SaveAppEntry)
                        }
                    }
                ) {
                    Text(
                        text = "Get Started",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif
                    )
                }
            } else {
                Box (
                    modifier = Modifier
                        .padding(Dimen.SmallSpace)
                        .background(PrimaryColor, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton (
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage (
                                    page = pagerState.currentPage + 1
                                )
                            }
                        }
                    ) {
                        Icon (
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "Next",
                            tint = Color.White
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}

@Composable
@Preview(showBackground = true)
fun OnBoardingScreenPreview() {
    OnBoardingScreen { }
}