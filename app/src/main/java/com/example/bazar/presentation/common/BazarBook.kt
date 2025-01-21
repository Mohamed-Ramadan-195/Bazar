package com.example.bazar.presentation.common

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.bazar.R
import com.example.bazar.data.remote.dto.Item
import com.example.bazar.util.Dimen.ExtraSmallSpace

@SuppressLint("ResourceAsColor")
@Composable
fun BazarBookItem (
    item: Item
) {
    Column (
        modifier = Modifier.padding(ExtraSmallSpace),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Image (
//            painter = painterResource(item.),
//            contentDescription = "book cover",
//            modifier = Modifier.height(80.dp),
//            contentScale = ContentScale.Crop
//        )
//        BazarSpacerHeight(ExtraSmallSpace)
        Text (
            modifier = Modifier.padding(horizontal = ExtraSmallSpace),
            text = item.volumeInfo.title,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Color(R.color.secondary_text)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BazarBookItemPreview() {

}