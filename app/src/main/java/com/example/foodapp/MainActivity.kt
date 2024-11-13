package com.example.foodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodapp.ui.theme.FoodAppTheme
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController) }
                    composable("food_list") { FoodListScreen(navController) }
                    composable("resto_grid") { RestaurantScreen(navController) }
                    composable("about") { AboutScreen(navController) }
                    composable("detail/{restaurantName}") { backStackEntry ->
                        val restaurantName = backStackEntry.arguments?.getString("restaurantName")
                        restaurantName?.let {
                            DetailRestoScreen(
                                restaurantName = it,
                                navController = navController
                            )
                        }
                    }

                }
            }
        }
    }
}
@Preview (showBackground = true)
@Composable
fun PreviewMainActivity() {
    MainActivity()
}

