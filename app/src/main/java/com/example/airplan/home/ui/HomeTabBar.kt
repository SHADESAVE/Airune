package com.example.airplan.home.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.airune.R
import java.util.*

enum class HomeTab {
    Flights, Hotels
}

@Composable
fun HomeTabBar(
    selectedTab: HomeTab,
    onTabSelected: (HomeTab) -> Unit,
) {
    HomeTabs(
        tabTitles = listOf("Полеты", "Отели"), //TODO Вынести
        selectedTab = selectedTab,
        onTabSelected = { newSelectedTab -> onTabSelected(HomeTab.values()[newSelectedTab.ordinal]) }
    )
}

@Composable
private fun HomeTabs(
    tabTitles: List<String>,
    selectedTab: HomeTab,
    onTabSelected: (HomeTab) -> Unit
) {
    Row {
        Row(Modifier.padding(top = 8.dp, start = 24.dp)) {
            Image(
                painter = when (selectedTab) {
                    HomeTab.Flights -> painterResource(id = R.drawable.ic_baseline_airplanemode_48)
                    HomeTab.Hotels -> painterResource(id = R.drawable.ic_baseline_hotel_48)
                },
                contentDescription = null
            )
        }
        TabRow(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            selectedTabIndex = selectedTab.ordinal,
            contentColor = MaterialTheme.colors.onSurface,
            indicator = { },
            divider = { }
        ) {
            tabTitles.forEachIndexed { index: Int, title: String ->
                val selected = index == selectedTab.ordinal
                Tab(
                    selected = selected,
                    onClick = { onTabSelected(HomeTab.values()[index]) }
                ) {
                    Text(
                        modifier = if (selected)
                            Modifier.getSelectedTabTitle()
                        else
                            Modifier.getTabTitle(),
                        text = title.toUpperCase(Locale.ROOT)
                    )
                }
            }
        }
    }
}

private fun Modifier.getSelectedTabTitle() =
    border(BorderStroke(2.dp, Color.White), RoundedCornerShape(16.dp))
        .then(Modifier.getTabTitle())


private fun Modifier.getTabTitle() =
    padding(vertical = 8.dp, horizontal = 16.dp)
