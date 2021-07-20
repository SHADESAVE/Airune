package com.example.airplan.home.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.airplan.home.domain.entity.Destination
import com.example.airplan.home.presentation.HomeViewModel
import com.example.airune.R

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    topPadding: Dp = 0.dp,
    viewModel: HomeViewModel = viewModel(),
) {
    Column(modifier = modifier) {
        Spacer(Modifier.padding(top = topPadding))

        var selectedTab by remember { mutableStateOf(HomeTab.Flights) }

        val destinationTo by viewModel.destinationTo.observeAsState()
        val tickets by viewModel.tickets.observeAsState()
        val hotels by viewModel.hotels.observeAsState()
        val state by viewModel.state.observeAsState()

        val (dialogShown, showDialog) = remember { mutableStateOf(false) }

        val onPeopleChanged: (Int) -> Unit = { viewModel.updatePeople(it) }
        val onExploreItemClicked: (Destination) -> Unit = { viewModel.openDeeplink(it.deeplink) }
        val onDateSelectionClicked: () -> Unit = { }
        val onPeopleLongPressed: () -> Unit = { }
        val onDestinationToInputChanged: (String) -> Unit = { viewModel.updateDestinationTo(it) }

        BackdropScaffold(
            scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed),
            frontLayerScrimColor = Color.Transparent,
            appBar = {
                HomeTabBar(selectedTab, onTabSelected = { selectedTab = it })
            },
            backLayerContent = {
                SearchSection(
                    viewModel = viewModel,
                    selectedTab = selectedTab,
                    onPeopleChanged = onPeopleChanged,
                    onDateSelectionClicked = onDateSelectionClicked,
                    onPeopleLongPressed = onPeopleLongPressed,
                    onDestinationToInputChanged = onDestinationToInputChanged,
                )
            },
            frontLayerContent = {
                when (selectedTab) {
                    HomeTab.Flights -> {
                        ExploreSection(
                            title = if (!destinationTo.isNullOrEmpty()) {
                                stringResource(R.string.tickets)
                            } else {
                                ""
                            },
                            exploreItem = if (!destinationTo.isNullOrEmpty()) {
                                tickets.orEmpty()
                            } else {
                                emptyList()
                            },
                            onItemClicked = onExploreItemClicked,
                        )
                    }
                    HomeTab.Hotels -> {
                        ExploreSection(
                            title = stringResource(R.string.hotels),
                            exploreItem = hotels.orEmpty(),
                            onItemClicked = onExploreItemClicked,
                        )
                    }
                }
            }
        )

        CabinClassDialog(dialogShown, showDialog)
    }
}