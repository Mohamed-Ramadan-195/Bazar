package com.example.bazar.domain.usecase.start

import com.example.bazar.domain.manager.LocalUserManager

class SaveAppEntryUseCase (
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() = localUserManager.saveAppEntry()
}