package com.example.bazar.presentation.onboarding.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bazar.presentation.common.BazarButton
import com.example.bazar.presentation.common.SpacerHeight
import com.example.bazar.presentation.common.BazarTextButton
import com.example.bazar.presentation.onboarding.components.OnBoardingPage
import com.example.bazar.presentation.onboarding.components.OnBoardingPageIndicator
import com.example.bazar.presentation.onboarding.model.pages
import com.example.bazar.util.Dimen.ExtraLargeSpace
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen (
    onBoardingEvent: (OnBoardingEvent) -> Unit
) {
    Column (modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0) { pages.size }
        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("Continue","")
                    1 -> listOf("Continue", "Back")
                    2 -> listOf("Get Started", "Back")
                    else -> listOf("","")
                }
            }
        }
        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }
        Spacer(modifier = Modifier.weight(1f))
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = ExtraLargeSpace)
                .navigationBarsPadding(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OnBoardingPageIndicator (
                modifier = Modifier.width(52.dp),
                pageCount = pages.size,
                selectedPage = pagerState.currentPage
            )
            SpacerHeight(12.dp)
            val scope = rememberCoroutineScope()
            if (buttonState.value[0].isNotEmpty()) {
                BazarButton (
                    text = buttonState.value[0],
                    onClick = {
                        scope.launch {
                            if (pagerState.currentPage == 2) {
                                onBoardingEvent(OnBoardingEvent.SaveAppEntry)
                            } else {
                                pagerState.animateScrollToPage (
                                    page = pagerState.currentPage + 1
                                )
                            }
                        }
                    }
                )
                BazarTextButton (
                    text = buttonState.value[1],
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage (
                                page = pagerState.currentPage - 1
                            )
                        }
                    }
                )
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