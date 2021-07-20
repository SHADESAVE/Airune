package com.example.airplan.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.airplan.home.domain.entity.Destination
import com.example.airplan.ui.theme.airplan_caption
import com.example.airplan.ui.theme.airplan_divider_color
import com.example.airplan.ui.theme.airplan_white
import com.example.airune.R
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState


@Composable
fun ExploreSection(
    title: String,
    exploreItem: List<Destination>,
    onItemClicked: (Destination) -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize(), color = airplan_white) {
        Column(modifier = Modifier.padding(start = 24.dp, top = 16.dp, end = 24.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.caption.copy(color = airplan_caption)
            )
            Spacer(Modifier.height(8.dp))
            LazyColumn(
                modifier = Modifier.weight(1f),
            ) {
                items(exploreItem) { exploreItem ->
                    Column(Modifier.fillParentMaxWidth()) {
                        ExploreItem(
                            modifier = Modifier.fillParentMaxWidth(),
                            item = exploreItem,
                            onItemClicked = onItemClicked
                        )
                        Divider(color = airplan_divider_color)
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(48.dp))
                }
            }
        }
    }
}

//TODO Разгребсти
@Composable
private fun ExploreItem(
    modifier: Modifier = Modifier,
    item: Destination,
    onItemClicked: (Destination) -> Unit
) {
    Row(
        modifier = modifier
            .clickable { onItemClicked(item) }
            .padding(top = 12.dp, bottom = 12.dp)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box {
                    val painter = rememberCoilPainter(item.agent?.imageUrl, fadeIn = true)
                    Image(
                        painter = painter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(width = 80.dp, height = 40.dp)
                    )
                    if (painter.loadState is ImageLoadState.Error) {
                        Text(
                            text = item.agent?.name.orEmpty(),
                            style = MaterialTheme.typography.h6,
                        )
                    }
                }
                Spacer(Modifier.width(8.dp))
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.body1,
                )
            }
            Spacer(Modifier.height(4.dp))
            Text(
                text = if (item.arrival.isEmpty()) item.departure else "${item.departure} – ${item.arrival}",
                style = MaterialTheme.typography.body1,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "${item.price}${item.currencySymbol}",
                style = MaterialTheme.typography.body1,
            )
            Spacer(Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size(
                        width = 16.dp,
                        height = 16.dp
                    ),
                    painter = painterResource(id = R.drawable.ic_baseline_access_time_24),
                    contentDescription = null,
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.caption.copy(color = airplan_caption)
                )
            }
        }
    }
}

