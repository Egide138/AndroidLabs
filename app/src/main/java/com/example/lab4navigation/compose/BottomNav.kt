package com.example.lab4navigation.compose
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.lab4navigation.NavigationItem

@Composable

fun BottomNavigationBar(navController: NavController)
{
  val items= listOf(NavigationItem.Home, NavigationItem.Profile,NavigationItem.Search)
  BottomAppBar(
    backgroundColor =MaterialTheme.colors.primary
  ) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    items.forEach { item ->
      BottomNavigationItem(
        icon = { Icon(painterResource(id = item.icon), contentDescription = "Icon", modifier = Modifier.size(30.dp))},
        label ={ Text(text = item.name)},
        alwaysShowLabel = true,
        selectedContentColor = Color.White,
        unselectedContentColor = Color.White.copy(0.4f),
        selected = currentRoute == item.route,
        onClick = {
          navController.navigate(item.route)
          {
            navController.graph.startDestinationRoute?.let { route ->
              popUpTo(route) {
                saveState = true
              }
            }
            launchSingleTop = true
            restoreState = true
          }
        }
      )
    }
  }
}
@Composable
fun NavigationOnDifferentPages(navController: NavHostController) {
  NavHost(navController, startDestination = NavigationItem.Home.route) {
    composable(NavigationItem.Home.route) {
      HomeScreen()
    }
    composable(NavigationItem.Search.route) {
      SearchScreen()
    }
    composable(NavigationItem.Profile.route) {
      ProfileScreen()
    }

  }
}