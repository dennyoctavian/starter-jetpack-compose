package com.dennyoctavian.ppobsimscompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dennyoctavian.ppobsimscompose.presentation.common.viewmodel.TokenViewModel
import com.dennyoctavian.ppobsimscompose.presentation.information.screens.HomeScreen
import com.dennyoctavian.ppobsimscompose.presentation.membership.screens.LoginScreen
import com.dennyoctavian.ppobsimscompose.presentation.membership.screens.ProfileScreen
import com.dennyoctavian.ppobsimscompose.presentation.membership.screens.RegisterScreen
import com.dennyoctavian.ppobsimscompose.presentation.transaction.screens.TopUpScreen
import com.dennyoctavian.ppobsimscompose.presentation.transaction.screens.TransactionHistoryScreen
import com.dennyoctavian.ppobsimscompose.presentation.transaction.screens.TransactionScreen

@Composable
fun AppNavigation() {
    val tokenViewModel: TokenViewModel = hiltViewModel()
    val navController = rememberNavController()

    var startDestination = ""
    if (tokenViewModel.getAccessToken() != null) {
        startDestination = "home"
    } else {
        startDestination = "login"
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable("home") {
            HomeBottomNavBar()
        }
        composable("login") {
            LoginScreen()
        }
        composable("register") {
            RegisterScreen()
        }
        composable("transaction") {
            TransactionScreen()
        }
    }
}

@Composable
fun HomeBottomNavBar() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable(BottomNavItem.Home.route) { HomeScreen() }
        composable(BottomNavItem.TopUp.route) { TopUpScreen() }
        composable(BottomNavItem.TransactionHistory.route) { TransactionHistoryScreen() }
        composable(BottomNavItem.Profile.route) { ProfileScreen() }
    }
}