package com.example.bazar.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bazar.R
import com.example.bazar.domain.model.Item
import com.example.bazar.util.Dimen.SmallSpace

@Composable
fun BazarAuthorItem (
    item: Item,
    onClick: (Item) -> Unit
) {
    Text (
        modifier = Modifier.clickable { onClick(item) }
            .padding(SmallSpace)
            .clip(RoundedCornerShape(SmallSpace)),
        text = item.volumeInfo.publisher,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        color = colorResource(R.color.primary_color)
    )
}