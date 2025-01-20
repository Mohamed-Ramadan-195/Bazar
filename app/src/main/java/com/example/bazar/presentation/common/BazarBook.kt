package com.example.bazar.presentation.common

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazar.R
import com.example.bazar.data.remote.dto.category.Work
import com.example.bazar.util.Dimen.ExtraSmallSpace

@SuppressLint("ResourceAsColor")
@Composable
fun BazarBookItem (
    work: Work
) {
    Column (
        modifier = Modifier.padding(ExtraSmallSpace),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image (
            painter = painterResource(work.cover_id),
            contentDescription = "book cover",
            modifier = Modifier.height(80.dp),
            contentScale = ContentScale.Crop
        )
        BazarSpacerHeight(ExtraSmallSpace)
        Text (
            modifier = Modifier.padding(horizontal = ExtraSmallSpace),
            text = work.title,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Color(R.color.secondary_text)
        )
    }
}

@Composable
fun BazarBooksList (
    modifier: Modifier = Modifier,
    categories: List<Work>
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        contentPadding = PaddingValues(all = 6.dp)
    ) {
        items(count = categories.size) {
            val category = categories[it]
            BazarBookItem (
                work = category
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BazarBookItemPreview() {

}