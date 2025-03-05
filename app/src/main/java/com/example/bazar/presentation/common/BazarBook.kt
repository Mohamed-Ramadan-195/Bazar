package com.example.bazar.presentation.common

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bazar.domain.model.Item
import com.example.bazar.ui.theme.SecondaryColor
import com.example.bazar.util.Dimen.ExtraSmallSpace
import com.example.bazar.util.Dimen.MediumSpace
import com.example.bazar.util.Dimen.SmallSpace

@SuppressLint("ResourceAsColor")
@Composable
fun BazarBookItem (
    modifier: Modifier = Modifier,
    item: Item,
    onClick: (Item) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(item) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage (
            modifier = modifier.size(150.dp).clip(RoundedCornerShape(SmallSpace)),
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(item.volumeInfo.imageLinks.smallThumbnail)
                .crossfade(true)
                .build(),
            contentDescription = "cover",
            contentScale = ContentScale.FillWidth
        )
        SpacerHeight(SmallSpace)
        Text (
            modifier = Modifier.padding(horizontal = ExtraSmallSpace),
            text = item.volumeInfo.title,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = SecondaryColor
        )
        SpacerHeight(MediumSpace)
    }
}