package com.example.airplan.components.input

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.airune.R
import com.example.airplan.components.input.PeopleInputAnimationState.Invalid
import com.example.airplan.components.input.PeopleInputAnimationState.Valid
import com.example.airplan.home.presentation.MAX_PEOPLE

enum class PeopleInputAnimationState { Valid, Invalid }

class PeopleUserInputState {
    var people by mutableStateOf(1)
        private set

    val animationState: MutableTransitionState<PeopleInputAnimationState> =
        MutableTransitionState(Valid)

    fun addPerson() {
        people = (people % (MAX_PEOPLE + 1)) + 1
        updateAnimationState()
    }

    private fun updateAnimationState() {
        val newState =
            if (people > MAX_PEOPLE) Invalid
            else Valid

        if (animationState.currentState != newState) animationState.targetState = newState
    }
}

@ExperimentalFoundationApi
@Composable
fun PeopleInput(
    suffix: String = "",
    onPeopleChanged: (Int) -> Unit,
    onPeopleLongPressed: () -> Unit,
) {
    val peopleState: PeopleUserInputState = remember { PeopleUserInputState() }

    Column {
        val transitionState = remember { peopleState.animationState }
        val tint = tintPeopleUserInput(transitionState)

        val people = peopleState.people
        val text =
            if (people == 1) "$people Взрослый$suffix" else "$people Взрослых$suffix" //TODO Сделать детский билет

        TextInput(
            modifier = Modifier.clickable(
                onClick = {
                    peopleState.addPerson()
                    onPeopleChanged(peopleState.people)
                },
            ),
            vectorImageId = R.drawable.ic_person,
            tint = tint.value
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.body1.copy(color = tint.value)
            )
        }
        if (transitionState.targetState == Invalid) {
            Text(
                text = LocalContext.current.getString(R.string.people_max_input_error, MAX_PEOPLE),
                style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.secondary)
            )
        }
    }
}

@Composable
private fun tintPeopleUserInput(
    transitionState: MutableTransitionState<PeopleInputAnimationState>
): State<Color> {
    val validColor = MaterialTheme.colors.onSurface
    val invalidColor = MaterialTheme.colors.secondary

    val transition = updateTransition(transitionState, label = "")
    return transition.animateColor(
        transitionSpec = { tween(durationMillis = 300) }, label = ""
    ) {
        if (it == Valid) validColor else invalidColor
    }
}
