package com.example.bazar.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bazar.domain.model.Item
import com.example.bazar.util.Dimen.SmallSpace
import com.example.bazar.util.Dimen.UnderMediumSpace
import kotlin.math.absoluteValue

@Composable
fun BookCardContent (
    index: Int,
    pagerState: PagerState,
    item: Item,
    onClick: (Item) -> Unit
) {
    val pageOffset = (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction

    Card (
        shape = RoundedCornerShape(UnderMediumSpace),
        modifier = Modifier.padding(SmallSpace).graphicsLayer {
            lerp (
                start = 0.85f.dp,
                stop = 1f.dp,
                fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f)
            ).also { scale ->
                scaleX = scale.value
                scaleY = scale.value
            }
            alpha = lerp (
                start = 0.5f.dp,
                stop = 1f.dp,
                fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f)
            ).value
        }
    ) {
        AsyncImage (
            modifier = Modifier.fillMaxWidth().height(300.dp).clickable { onClick(item) },
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(item.volumeInfo.imageLinks.smallThumbnail)
                .crossfade(true)
                .build(),
            contentDescription = "cover",
            contentScale = ContentScale.FillBounds
        )
        SpacerHeight(SmallSpace)
        Text (
            modifier = Modifier.padding(horizontal = SmallSpace),
            text = item.volumeInfo.title,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Black
        )
        SpacerHeight(SmallSpace)
    }
}