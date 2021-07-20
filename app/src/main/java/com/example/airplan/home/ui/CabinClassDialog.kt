package com.example.airplan.home.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.airune.R

@Composable
fun CabinClassDialog(dialogShown: Boolean, showDialog: (Boolean) -> Unit) {
    if (dialogShown) {
        AlertDialog(
            backgroundColor = MaterialTheme.colors.primary,
            onDismissRequest = {},
            title = { Text(text = stringResource(R.string.cabin_class_choose)) },
            buttons = {
                Column(Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp)) {
                    TextButton(
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.primaryVariant,
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { showDialog(false) }) {
                        Text(
                            style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface),
                            text = stringResource(R.string.cabin_class_economy),
                        )
                    }
                    Spacer(Modifier.height(8.dp))
                    TextButton(
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.primaryVariant,
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { showDialog(false) }) {
                        Text(
                            style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface),
                            text = stringResource(R.string.cabin_class_buisness),
                        )
                    }
                }
            }
        )
    }
}