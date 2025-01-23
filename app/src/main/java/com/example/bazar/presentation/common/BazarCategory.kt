package com.example.bazar.presentation.common

import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.bazar.presentation.screen.category.state.Category

@SuppressLint("ResourceAsColor")
@Composable
fun BazarCategoryItem(
    category: Category,
    onClick: (Category) -> Unit,
) {
    TextButton(
        onClick = { onClick(category) }
    ) {
        Text(
            text = category.category,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = category.textColor,
            fontWeight = if (category.isSelected) FontWeight.Bold else FontWeight.SemiBold
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BazarCategoryItemPreview() {
    BazarCategoryItem(
        category = Category("England"),
        onClick = {}
    )
}

//@Composable
//fun BazarList (books: List<Item>) {
//    LazyColumn {
//        items(count = books.size) { it ->
//            BazarBookItem (
//                item = books[it]
//            )
//        }
//    }
//}