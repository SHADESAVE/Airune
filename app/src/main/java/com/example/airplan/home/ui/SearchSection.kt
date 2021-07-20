package com.example.airplan.home.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.airplan.components.input.EditableInput
import com.example.airplan.components.input.PeopleInput
import com.example.airplan.components.input.TextInput
import com.example.airplan.home.presentation.HomeViewModel
import com.example.airplan.ui.theme.captionTextStyle
import com.example.airune.R

@ExperimentalFoundationApi
@Composable
fun SearchSection(
    viewModel: HomeViewModel,
    selectedTab: HomeTab,
    onPeopleChanged: (Int) -> Unit,
    onPeopleLongPressed: () -> Unit,
    onDateSelectionClicked: () -> Unit,
    onDestinationToInputChanged: (String) -> Unit,
) {
    val datesSelected = "06.07.2021"

    when (selectedTab) {
        HomeTab.Flights -> FlightsSearchContent(
            datesSelected,
            onPeopleChanged,
            onDateSelectionClicked,
            onPeopleLongPressed,
            onDestinationToInputChanged,
        )
        HomeTab.Hotels -> HotelsSearchContent(
            datesSelected,
            onPeopleChanged,
            onDateSelectionClicked,
            onPeopleLongPressed,
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun FlightsSearchContent(
    datesSelected: String,
    onPeopleChanged: (Int) -> Unit,
    onPeopleLongPressed: () -> Unit,
    onDateSelectionClicked: () -> Unit,
    onDestinationToInputChanged: (String) -> Unit,
) {
    SearchContainer {
        PeopleInput(
            suffix = ", эконом", //TODO Сделать бизнес
            onPeopleChanged = onPeopleChanged,
            onPeopleLongPressed = onPeopleLongPressed
        )
        Spacer(Modifier.height(8.dp))
        DestinationFrom()
        Spacer(Modifier.height(8.dp))
        DestinationTo(onDestinationToInputChanged)
        Spacer(Modifier.height(8.dp))
        DatesUserInput(datesSelected, onDateSelectionClicked)
    }
}

@ExperimentalFoundationApi
@Composable
fun HotelsSearchContent(
    datesSelected: String,
    onPeopleChanged: (Int) -> Unit,
    onPeopleLongPressed: () -> Unit,
    onDateSelectionClicked: () -> Unit,
) {
    SearchContainer {
        PeopleInput(
            onPeopleChanged = onPeopleChanged,
            onPeopleLongPressed = onPeopleLongPressed
        )
        Spacer(Modifier.height(8.dp))
        DatesUserInput(datesSelected, onDateSelectionClicked = onDateSelectionClicked)
        Spacer(Modifier.height(8.dp))
        DestinationFrom()
    }
}

@Composable
private fun SearchContainer(
    content: @Composable () -> Unit
) {
    Column(
        Modifier.padding(
            start = 24.dp,
            top = 0.dp,
            end = 24.dp,
            bottom = 12.dp
        )
    ) {
        content()
    }
}

@Composable
fun DestinationFrom() {
    TextInput(vectorImageId = R.drawable.ic_location) {
        Text(text = "Санкт-Петербург, Пулково")
//        Text(text = "Москва")
    }
}

@Composable
fun DestinationTo(onDestinationToInputChanged: (String) -> Unit) {
    EditableInput(
        hint = LocalContext.current.getString(R.string.flight_destination_choose),
        vectorImageId = R.drawable.ic_plane,
        onInputChanged = { onDestinationToInputChanged(it) }
    )
}

@Composable
fun DatesUserInput(datesSelected: String, onDateSelectionClicked: () -> Unit) {
    TextInput(
        modifier = Modifier.clickable(onClick = onDateSelectionClicked),
        caption = if (datesSelected.isEmpty()) stringResource(R.string.choose_date) else null,
        vectorImageId = R.drawable.ic_calendar,
    ) {
        Text(text = datesSelected)
    }
}