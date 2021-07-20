package com.example.airplan.components.input

import androidx.annotation.DrawableRes
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.TextFieldValue
import com.example.airplan.ui.theme.captionTextStyle

@Composable
fun EditableInput(
    hint: String,
    caption: String? = null,
    @DrawableRes vectorImageId: Int? = null,
    onInputChanged: (String) -> Unit
) {
    var textFieldState by remember { mutableStateOf(TextFieldValue(text = hint)) }
    val isHint = { textFieldState.text == hint }

    TextInput(
        caption = caption,
        showCaption = { !isHint() },
        vectorImageId = vectorImageId,
        tintIcon = { !isHint() }
    ) {
        BasicTextField(
            value = textFieldState,
            onValueChange = {
                textFieldState = it
                if (!isHint()) onInputChanged(textFieldState.text)
            },
            textStyle = if (isHint()) {
                captionTextStyle.copy(color = LocalContentColor.current)
            } else {
                MaterialTheme.typography.body1.copy(color = LocalContentColor.current)
            },
            cursorBrush = SolidColor(LocalContentColor.current)
        )
    }
}