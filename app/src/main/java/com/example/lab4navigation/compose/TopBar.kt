package com.example.lab4navigation.compose

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.lab4navigation.R

@Composable
fun topBarcompose()
{
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.toptext))
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.ArrowBack, stringResource(id = R.string.Description))
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 10.dp
    )

}