package com.example.bazar.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bazar.R
import com.example.bazar.domain.model.Item
import com.example.bazar.presentation.common.BazarAuthorItem
import com.example.bazar.presentation.common.BazarBookItem
import com.example.bazar.presentation.common.BazarSpacerHeight
import com.example.bazar.presentation.common.BazarTextHeadline
import com.example.bazar.presentation.screen.category.state.SubjectState
import com.example.bazar.util.Dimen.ExtraSmallSpace
import com.example.bazar.util.Dimen.MediumSpace

@Composable
fun HomeScreen (
    subjectState: SubjectState,
    navigateToSearch: () -> Unit,
    navigateToDetails: (Item) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(MediumSpace)
            .statusBarsPadding()
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BazarTextHeadline("Home")
            IconButton (
                onClick = { navigateToSearch() }
            ) {
                Icon (
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search"
                )
            }
        }
        BazarSpacerHeight(MediumSpace)
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text (
                text = "What do you want to read?",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.primary_text)
            )
            Text (
                text = "See all",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.primary_color)
            )
        }
        BazarSpacerHeight(MediumSpace)
        LazyRow {
            items(subjectState.subjects.size) { item ->
                BazarBookItem (
                    item = subjectState.subjects[item],
                    onClick = { navigateToDetails(subjectState.subjects[item]) }
                )
            }
        }
        BazarSpacerHeight(MediumSpace)
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text (
                text = "Publishers",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.primary_text)
            )
            Text (
                text = "See all",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.primary_color)
            )
        }
        BazarSpacerHeight(ExtraSmallSpace)
        LazyColumn {
            items(subjectState.subjects.size) { item ->
                BazarAuthorItem (
                    item = subjectState.subjects[item],
                    onClick = { navigateToDetails(subjectState.subjects[item]) }
                )
            }
        }
    }
}