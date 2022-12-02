package com.example.lab4navigation

import androidx.compose.ui.res.stringResource


sealed class NavigationItem(var route: String,var icon: Int, var name: String )
{
    object  Home : NavigationItem("Home", R.drawable.ic_baseline_home_24,"Home")
    object  Profile : NavigationItem("profile", R.drawable.ic_baseline_person_24,"Profile")
    object  Search : NavigationItem("search", R.drawable.ic_baseline_search_24,"Search")
}
