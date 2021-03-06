package com.souttab.todocompose.ui.screens.list

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.souttab.todocompose.ui.theme.topAppBarBackgroundColor
import com.souttab.todocompose.ui.theme.topAppBarContentColor

@Composable
fun ListAppBar() {
    DefaultListBar()
}

@Composable
fun DefaultListBar() {
    TopAppBar(
        title = {
            Text(
                text = "Tasks",
                color = MaterialTheme.colors.topAppBarContentColor,
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
@Preview
private fun DefaultListAppbar() {
    DefaultListBar()
}