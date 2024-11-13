package com.example.foodapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

data class Desc(
    val food: String,
    val rekomendasi: String,
    val image: Int )

@OptIn (ExperimentalMaterial3Api::class)
@Composable
fun FoodListScreen (navController: NavController) {
   Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("All of Food",  fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack("home", inclusive = false) }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.LightGray
                )
            )
        }

    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(text = "Kategori", style = MaterialTheme.typography.titleMedium)
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                val categories = listOf("Semua", "Makanan Berat", "Makanan Ringan", "Minuman", "Fast Food", "Asian Food", "Korean Food","Healthy Food","Dessert","Buah-Buahan" )
                items(categories) { category ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                            },
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Box(
                            modifier = Modifier.padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = category)
                        }
                    }
                }
            }
            Text(text = "Daftar Makanan", style = MaterialTheme.typography.titleMedium)
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                val foodItems = listOf(
                    Desc(food = "Nasi Goreng",rekomendasi = "10",image = R.drawable.nasi_goreng),
                    Desc(food = "Mie Goreng", rekomendasi = "7", image =  R.drawable.mie_goreng),
                    Desc(food ="Sate Ayam", rekomendasi ="8",image = R.drawable.sate),
                    Desc(food ="Rendang", rekomendasi ="9", image =R.drawable.rendang),
                    Desc(food ="Sushi",rekomendasi = "3",image = R.drawable.sushi),
                    Desc(food ="Cheesecake", rekomendasi ="10",image = R.drawable.cheesecake),
                    Desc(food ="Soto", rekomendasi ="2",image =R.drawable.soto),
                    Desc(food ="Steak",rekomendasi = "11",image = R.drawable.steak),
                    Desc(food ="Mie Ayam",rekomendasi = "2",image = R.drawable.mie_ayam),
                    Desc(food ="Ramen", rekomendasi ="4", image = R.drawable.ramen)
                )

                items(foodItems) { fooditem ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(end = 16.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = fooditem.image),
                                    contentDescription = fooditem.food,
                                    modifier = Modifier.fillMaxSize().clip(
                                        RoundedCornerShape(10.dp)
                                    ))
                            }
                            Column {
                                Text(
                                    text = fooditem.food,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text(
                                    text = fooditem.rekomendasi + " Rekomendasi Untukmu",
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                        }
                    }
                }
            }
        }
   }


@Preview(showBackground = true)
@Composable
fun PreviewFoodListScreen() {
    FoodListScreen(navController = rememberNavController())
}
