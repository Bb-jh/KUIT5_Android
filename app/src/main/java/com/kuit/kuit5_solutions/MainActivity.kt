package com.kuit.kuit5_solutions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.kuit.kuit5_solutions.navigation.BottomNavItem
import com.kuit.kuit5_solutions.navigation.KuitNavGraph
import com.kuit.kuit5_solutions.navigation.Route
import com.kuit.kuit5_solutions.ui.theme.KUIT5_SolutionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KUIT5_SolutionsTheme {
                val navController = rememberNavController()

                val navBarItems = listOf(
                    BottomNavItem(
                        label = "홈",
                        route = Route.Home.route,
                        selectedIcon = R.drawable.ic_home,
                        unselectedIcon = R.drawable.ic_x
                    ),
                    BottomNavItem(
                        label = "자산",
                        route = Route.Assets.route,
                        selectedIcon = R.drawable.ic_home,
                        unselectedIcon = R.drawable.ic_x
                    ),
                    BottomNavItem(
                        label = "가계부",
                        route = Route.Records.route,
                        selectedIcon = R.drawable.ic_home,
                        unselectedIcon = R.drawable.ic_x
                    ),
                    BottomNavItem(
                        label = "건강",
                        route = Route.Health.route,
                        selectedIcon = R.drawable.ic_home,
                        unselectedIcon = R.drawable.ic_x
                    ),
                    BottomNavItem(
                        label = "금융쇼핑",
                        route = Route.Shopping.route,
                        selectedIcon = R.drawable.ic_home,
                        unselectedIcon = R.drawable.ic_x
                    )
                )

                var selectedIndex by rememberSaveable { mutableIntStateOf(0) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets.safeDrawing,
                    bottomBar = {
                        NavigationBar {
                            navBarItems.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    selected = selectedIndex == index,
                                    onClick = {
                                        selectedIndex = index
                                        navController.navigate(item.route)
                                    },
                                    icon = {
                                        Icon(
                                            painter = painterResource(
                                                if (index == selectedIndex){
                                                    item.selectedIcon
                                                } else item.unselectedIcon
                                            ),
                                            contentDescription = item.label
                                        )
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    KuitNavGraph(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
