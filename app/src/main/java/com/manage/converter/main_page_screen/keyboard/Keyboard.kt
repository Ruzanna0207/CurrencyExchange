package com.manage.converter.main_page_screen.keyboard

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.manage.converter.R
import com.manage.converter.compose_state.CheckValueAction
import com.manage.converter.core.consts.STORAGE.EMPTY
import com.manage.converter.core.consts.STORAGE.INT_ZERO
import com.manage.converter.core.consts.STORAGE.listNumbers
import com.manage.converter.main_page_screen.icon.IconBackground
import com.manage.converter.main_page_screen.icon.IconWidget
import com.manage.converter.main_page_screen.icon.NoBackgroundIconSize
import com.manage.converter.ui.theme.borderRadius
import com.manage.converter.ui.theme.borderWidths
import com.manage.converter.ui.theme.sizing
import com.manage.converter.ui.theme.spacing
import kotlinx.coroutines.delay

data class ButtonNum(val number: String, val chars: String)

@Composable
fun CheckValueWithKeyboard(onAction: (CheckValueAction) -> Unit) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Keyboard(enteredNum = {
            onAction(CheckValueAction.OnValueCodeEntered(it))
        }, clearAll = {
            onAction(CheckValueAction.OnClearAllEnteredValues)
        })
    }
}

@Composable
fun Keyboard(
    modifier: Modifier = Modifier,
    enteredNum: (String) -> Unit,
    clearAll: () -> Unit
) {
    var value by remember { mutableStateOf(EMPTY) }
    val list = arrayListOf<String>()

    Box(modifier.padding(top = spacing.padding16)) {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(spacing.padding16)
                .align(AbsoluteAlignment.CenterRight),
            contentPadding = PaddingValues(spacing.padding8),
            columns = GridCells.Fixed(3),
        ) {
            items(listNumbers.subList(INT_ZERO, listNumbers.lastIndex)) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(bottom = spacing.padding12),
                ) {
                    NumButton(detail = it) {
                        list.add(it.number)
                        value = list.joinToString(EMPTY)
                        enteredNum(value)
                    }
                }
            }

            item {
                if (value.isNotEmpty()) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.padding(bottom = spacing.padding12),
                    ) {
                        ActionButton(icon = R.drawable.baseline_restart_alt_24) {
                            clearAll()
                            list.clear()
                            value = list.joinToString(EMPTY)
                            enteredNum(value)
                        }
                    }
                } else Box(modifier = Modifier.padding(bottom = spacing.padding12))
            }

            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(bottom = spacing.padding16),
                ) {
                    NumButton(detail = listNumbers.last()) {
                        if (list.size >= 1) {
                            list.add(listNumbers.last().number)
                            value = list.joinToString(EMPTY)
                            enteredNum(value)
                        }
                    }
                }
            }

            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(bottom = spacing.padding12),
                ) {
                    ActionButton(icon = R.drawable.ic_search_clear) {
                        if (list.lastIndex >= INT_ZERO) {
                            list.removeAt(list.lastIndex)
                        }
                        value = list.joinToString(EMPTY)
                        enteredNum(value)
                    }
                }
            }
        }
    }
}

@Composable
fun NumButton(detail: ButtonNum, onClick: () -> Unit) {
    var isClicked by remember { mutableStateOf(false) }
    val size: Dp by animateDpAsState(if (isClicked) 64.dp else 72.dp)
    val borderColor by animateColorAsState(if (isClicked) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary)

    LaunchedEffect(isClicked) {
        if (isClicked) {
            delay(500)
            isClicked = false
        }
    }

    Box(
        modifier = Modifier
            .size(size)
            .border(
                width = borderWidths.borderWidth2,
                color = borderColor,
                shape = RoundedCornerShape(borderRadius.borderRadius16)
            )
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }) {
                isClicked = true
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = detail.number,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.headlineLarge,
            )
            Text(
                text = detail.chars,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                overflow = TextOverflow.Visible
            )
        }
    }
}

@Composable
fun ActionButton(icon: Int, onClick: () -> Unit) {
    Box(modifier = Modifier
        .size(sizing.size72)
        .clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }) {
            onClick()
        }, contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            IconWidget(
                painter = painterResource(icon),
                iconBackground = IconBackground.NoBackground(NoBackgroundIconSize.Medium),
                modifier = Modifier
            )
        }
    }
}