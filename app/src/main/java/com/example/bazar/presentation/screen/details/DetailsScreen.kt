package com.example.bazar.presentation.screen.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bazar.R
import com.example.bazar.domain.model.Item
import com.example.bazar.presentation.common.BazarSpacerHeight
import com.example.bazar.util.Dimen.SmallSpace

@Composable
fun DetailsScreen (
    item: Item?,
    navigateUp: () -> Unit
) {
    val context = LocalContext.current
    Column (
        modifier = Modifier.fillMaxWidth().padding(SmallSpace)
    ) {
//        BazarTextHeadline("Details")
//        BazarSpacerHeight(SmallSpace)
        AsyncImage (
            modifier = Modifier.fillMaxWidth().weight(0.3f),
            model = ImageRequest.Builder(context = context)
                .data(item?.volumeInfo!!.imageLinks.thumbnail)
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
            color = colorResource(R.color.primary_text),
            modifier = Modifier.fillMaxWidth()
        )
        Text (
            text = item.volumeInfo.subtitle,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(R.color.secondary_text),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

