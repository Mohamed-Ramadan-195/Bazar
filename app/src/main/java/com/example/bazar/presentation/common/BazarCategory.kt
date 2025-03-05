package com.example.bazar.presentation.common

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.bazar.presentation.screen.category.state.Category
import com.example.bazar.util.Dimen.SmallSpace

@SuppressLint("ResourceAsColor")
@Composable
fun BazarCategoryItem(
    category: Category,
    onClick: (Category) -> Unit,
) {
    TextButton(
        onClick = { onClick(category) }
    ) {
        Box (
            modifier = Modifier
                .background(category.boxColor, RoundedCornerShape(SmallSpace))
                .padding(SmallSpace),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = category.category,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                color = category.textColor,
                fontFamily = FontFamily.Serif,
                fontWeight = if (category.isSelected) FontWeight.Bold else FontWeight.SemiBold
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BazarCategoryItemPreview() {
    BazarCategoryItem(
        category = Category("Programming"),
        onClick = {}
    )
}