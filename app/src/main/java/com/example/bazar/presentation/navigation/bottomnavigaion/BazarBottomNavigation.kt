package com.example.bazar.presentation.navigation.bottomnavigaion

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazar.ui.theme.PrimaryColor
import com.example.bazar.ui.theme.SecondaryColor

@Composable
fun BazarBottomNavigation (
    items: List<BottomNavigationItem>,
    onItemSelected: Int,
    onItemClick: (Int) -> Unit
) {
    NavigationBar (
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.navigationBars)
            .clip(RectangleShape)
            .border(width = 1.dp, color = SecondaryColor, shape = RectangleShape),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem (
                selected = index == onItemSelected,
                onClick = { onItemClick(index) },
                icon = {
                    Icon (
                        painter = painterResource (
                            if (index == onItemSelected) item.iconFocused
                            else item.icon
                        ),
                        contentDescription = "Bottom Navigation Icon",
                        modifier = Modifier.size(20.dp)
                    )
                },
                label = {
                    Text (
                        text = item.label,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                colors = NavigationBarItemDefaults.colors (
                    unselectedIconColor = SecondaryColor,
                    selectedIconColor = PrimaryColor,
                    unselectedTextColor = SecondaryColor,
                    selectedTextColor = PrimaryColor,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}