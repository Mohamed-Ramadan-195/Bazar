package com.example.bazar.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.bazar.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BazarTopBar (
    title: String,
    onBackClick: () -> Unit,
) {
    TopAppBar (
        title = { Text(text = title) },
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.topAppBarColors (
            containerColor = Color.Transparent,
            actionIconContentColor = colorResource(R.color.secondary_text)
        ),
        navigationIcon = {
            IconButton (
                onClick = onBackClick
            ) {
                Icon (
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "back"
                )
            }
        }
    )
}