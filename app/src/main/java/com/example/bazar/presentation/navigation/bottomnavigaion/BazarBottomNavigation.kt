package com.example.bazar.presentation.navigation.bottomnavigaion

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazar.R
import com.example.bazar.ui.theme.BazarTheme
import com.example.bazar.util.Dimen.SmallSpace

@Composable
fun BazarBottomNavigation (
    items: List<BottomNavigationItem>,
    onItemSelected: Int,
    onItemClick: (Int) -> Unit
) {
    NavigationBar (
        modifier = Modifier.fillMaxWidth(),
        contentColor = MaterialTheme.colorScheme.background,
        tonalElevation = 10.dp
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem (
                selected = index == onItemSelected,
                onClick = { onItemClick(index) },
                icon = {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon (
                            painter = painterResource(item.icon),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.height(SmallSpace))
                        Text (
                            text = item.address,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors (
                    unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurface,
                    selectedTextColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun BazarBottomNavigationPreview() {
    BazarTheme {
        BazarBottomNavigation (
            items = listOf (
                BottomNavigationItem (
                    icon = R.drawable.ic_home,
                    address = stringResource(R.string.home)
                ),
                BottomNavigationItem (
                    icon = R.drawable.ic_category,
                    address = stringResource(R.string.category)
                ),
                BottomNavigationItem (
                    icon = R.drawable.ic_cart,
                    address = stringResource(R.string.cart)
                ),
                BottomNavigationItem (
                    icon = R.drawable.ic_profile,
                    address = stringResource(R.string.profile)
                )
            ),
            onItemSelected = 2,
            onItemClick = { }
        )
    }
}