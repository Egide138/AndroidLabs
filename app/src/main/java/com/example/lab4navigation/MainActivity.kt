package com.example.lab4navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.lab4navigation.compose.BottomNavigationBar
import com.example.lab4navigation.compose.NavigationOnDifferentPages
import com.example.lab4navigation.compose.topBarcompose
import com.example.lab4navigation.ui.theme.Lab4NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab4NavigationTheme {
                // A surface container using the 'background' color from the theme

                    MainFunction()

            }
        }
    }
}
@Composable
fun MainFunction() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {topBarcompose()},
        bottomBar = { BottomNavigationBar(navController) },
        content = {
            NavigationOnDifferentPages(navController = navController)
        },
        backgroundColor = MaterialTheme.colors.secondary)
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab4NavigationTheme {
        MainFunction()
    }
}