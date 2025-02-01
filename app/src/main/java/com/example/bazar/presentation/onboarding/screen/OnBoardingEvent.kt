package com.example.bazar.presentation.onboarding.screen

sealed class OnBoardingEvent {
    data object SaveAppEntry: OnBoardingEvent()
}