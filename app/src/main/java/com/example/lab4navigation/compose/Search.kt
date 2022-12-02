package com.example.lab4navigation.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab4navigation.R

@Composable
fun SearchScreen()
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.secondary)
            .wrapContentSize(Alignment.Center)
    ) {
        Image(painter = painterResource(id = R.drawable.egide), contentDescription = "",modifier = Modifier.align(Alignment.CenterHorizontally))
        Text(text = stringResource(id = R.string.Searchtext),
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 45.sp)
    }
}