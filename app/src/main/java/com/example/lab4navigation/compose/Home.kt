package com.example.lab4navigation.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.lab4navigation.R

@Composable
fun HomeScreen()
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.secondary)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(text = stringResource(id = R.string.hometext),
            fontWeight = FontWeight.Bold,
            color =Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 45.sp)
    }
}