package com.example.bazar.presentation.screen.details

import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bazar.R
import com.example.bazar.domain.model.Item
import com.example.bazar.presentation.common.SpacerHeight
import com.example.bazar.presentation.screen.favorites.FavoriteEvent
import com.example.bazar.presentation.screen.favorites.FavoriteViewModel
import com.example.bazar.ui.theme.PrimaryColor
import com.example.bazar.ui.theme.SecondaryColor
import com.example.bazar.util.Dimen.ExtraSmallSpace
import com.example.bazar.util.Dimen.MediumSpace
import com.example.bazar.util.Dimen.SmallSpace

@Composable
fun DetailsScreen (
    item: Item,
    navigateUp: () -> Unit
) {
    val favoriteViewModel: FavoriteViewModel = hiltViewModel()

    if (favoriteViewModel.sideEffect != null) {
        Toast.makeText (
            LocalContext.current,
            favoriteViewModel.sideEffect,
            Toast.LENGTH_SHORT
        ).show()
        favoriteViewModel.onEvent(FavoriteEvent.RemoveSideEffect)
    }

    val favoriteBooks = favoriteViewModel.favoriteBooks

    DetailsScreenContent (
        item = item,
        favoriteEvent = favoriteViewModel::onEvent,
        navigateUp = navigateUp,
        favoriteBooks = favoriteBooks
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreenContent (
    item: Item,
    favoriteEvent: (FavoriteEvent) -> Unit,
    navigateUp: () -> Unit,
    favoriteBooks: Set<String>
) {
    val isFavorite = item.id in favoriteBooks

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(all = MediumSpace)
            .navigationBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        TopAppBar (
            modifier = Modifier.fillMaxWidth(),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
                titleContentColor = SecondaryColor,
                navigationIconContentColor = SecondaryColor,
                actionIconContentColor = SecondaryColor
            ),
            title = {
                Text (
                    text = "Details",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = { navigateUp() }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                    )
                }
            }
        )

        // Book Cover
        AsyncImage (
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = MediumSpace)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(item.volumeInfo.imageLinks.smallThumbnail)
                .build(),
            contentDescription = "cover",
            contentScale = ContentScale.FillWidth
        )
        SpacerHeight(SmallSpace)

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = { favoriteEvent(FavoriteEvent.OperationsInBook(item = item)) }
            ) {
                Icon(
                    painter = painterResource(
                        if (isFavorite) R.drawable.ic_favorite_focused
                        else R.drawable.ic_favorite
                    ),
                    contentDescription = "favorite",
                    tint = if (isFavorite) PrimaryColor else SecondaryColor
                )
            }
        }
        SpacerHeight(MediumSpace)

        Text (
            text = item.volumeInfo.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = colorResource(R.color.primary_text)
        )
        Text (
            text = item.volumeInfo.subtitle,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Serif,
            color = colorResource(R.color.secondary_text)
        )
        SpacerHeight(MediumSpace)

        Text(
            text = "Authors",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = colorResource(R.color.primary_text)
        )
        SpacerHeight(ExtraSmallSpace)
        Text(
            text = item.volumeInfo.authors.joinToString(", "),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.Serif,
            color = colorResource(R.color.secondary_text)
        )
        SpacerHeight(MediumSpace)

        Text(
            text = "Description",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = colorResource(R.color.primary_text)
        )
        SpacerHeight(ExtraSmallSpace)
        var expanded by remember { mutableStateOf(false) }
        Text(
            modifier = Modifier
                .animateContentSize()
                .clickable {
                    expanded = !expanded
                },
            text = item.volumeInfo.description,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.Serif,
            maxLines = if (!expanded) 3 else 10,
            color = colorResource(R.color.secondary_text)
        )
        SpacerHeight(MediumSpace)

        Text(
            text = "Publisher",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = colorResource(R.color.primary_text)
        )
        SpacerHeight(ExtraSmallSpace)
        Text(
            text = item.volumeInfo.publisher,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.Serif,
            color = colorResource(R.color.secondary_text)
        )
    }
}

