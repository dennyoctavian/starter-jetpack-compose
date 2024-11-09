package com.dennyoctavian.ppobsimscompose.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    data object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    data object TopUp : BottomNavItem("search", Icons.Outlined.Menu, "Search")
    data object TransactionHistory : BottomNavItem("search", Icons.Default.DateRange, "Search")
    data object Profile : BottomNavItem("profile", Icons.Default.Person, "Profile")
}

val bottomNavItems = listOf(
    BottomNavItem.Home,
    BottomNavItem.TopUp,
    BottomNavItem.TransactionHistory,
    BottomNavItem.Profile
)