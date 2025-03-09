package com.kuit.kuit5_solutions.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kuit.kuit5_solutions.AssetsScreen
import com.kuit.kuit5_solutions.HealthScreen
import com.kuit.kuit5_solutions.HomeScreen
import com.kuit.kuit5_solutions.RecordsScreen
import com.kuit.kuit5_solutions.ShoppingScreen

@Composable
fun KuitNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Route.Home.route,
    ){
        // 홈
        composable(route = Route.Home.route) {
            HomeScreen()
        }
        // 자산
        composable(route = Route.Assets.route) {
            AssetsScreen()
        }
        // 가계부
        composable(route = Route.Records.route) {
            RecordsScreen()
        }
        // 건강
        composable(route = Route.Health.route) {
            HealthScreen()
        }
        // 금융쇼핑
        composable(route = Route.Shopping.route) {
            ShoppingScreen()
        }
    }
}