package com.example.bazar.presentation.screen.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bazar.R
import com.example.bazar.domain.model.Item
import com.example.bazar.presentation.common.BazarSpacerHeight
import com.example.bazar.presentation.common.BazarTopBar
import com.example.bazar.util.Dimen.MediumSpace
import com.example.bazar.util.Dimen.SmallSpace

@Composable
fun DetailsScreen (
    item: Item?,
    detailsEvent: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit
) {
    val context = LocalContext.current
    Column (
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(all = MediumSpace)
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        BazarTopBar (
            title = "Details",
            onBackClick = navigateUp,
            onBookmarkClick = { detailsEvent(DetailsEvent.OperationsBook(item!!)) }
        )
        AsyncImage (
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = MediumSpace)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context = context)
                .data(item?.volumeInfo!!.imageLinks.smallThumbnail)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .build(),
            contentDescription = "cover",
            contentScale = ContentScale.FillWidth
        )
        BazarSpacerHeight(SmallSpace)
        Text (
            text = item.volumeInfo.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.primary_text)
        )
        Text (
            text = item.volumeInfo.subtitle,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(R.color.secondary_text)
        )
        BazarSpacerHeight(SmallSpace)
        Text(
            text = "Authors",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.primary_text)
        )
        Text(
            text = item.volumeInfo.authors.joinToString(", "),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = colorResource(R.color.secondary_text)
        )
        BazarSpacerHeight(SmallSpace)
        Text(
            text = "Description",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.primary_text)
        )
        Text(
            text = item.volumeInfo.description,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            maxLines = 5,
            color = colorResource(R.color.secondary_text)
        )
        BazarSpacerHeight(SmallSpace)
        Text(
            text = "Publisher",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.primary_text)
        )
        Text(
            text = item.volumeInfo.publisher,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = colorResource(R.color.secondary_text)
        )
    }
}

