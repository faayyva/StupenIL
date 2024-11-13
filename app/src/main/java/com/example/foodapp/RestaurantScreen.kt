package com.example.foodapp

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodapp.ui.theme.FoodAppTheme

data class Restaurant(
    val name: String,
    val visitorCount: String,
    val distance: String,
    val image: Int
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Rekomendasi Resto dan Cafe", fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
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
        }){ padding ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(8.dp)
    )
    {
    val restaurants = listOf(
        Restaurant(
            name = "RM Lamun O",
            visitorCount = ">2rb Pengunjung/hari",
            distance = "13 km",
            image = R.drawable.lamunombak
        ),
        Restaurant(
            name = "Cafe Robusta",
            visitorCount = ">1rb Pengunjung/hari",
            distance = "6 km",
            image = R.drawable.cafe1
        ),
        Restaurant(
            name = "Ramen Jaya",
            visitorCount = ">2rb Pengunjung/hari",
            distance = "4 km",
            image = R.drawable.ramenresto
        ),
        Restaurant(
            name = "Japan Cafe",
            visitorCount = ">1rb Pengunjung/hari",
            distance = "2 km",
            image = R.drawable.cafe2
        ),
        Restaurant(
            name = "Cafe Damas",
            visitorCount = ">1rb Pengunjung/hari",
            distance = "6 km",
            image = R.drawable.cafe3
        ),
        Restaurant(
            name = "Cafe Galileo",
            visitorCount = ">1rb Pengunjung/hari",
            distance = "7 km",
            image = R.drawable.resto1
        ),
        Restaurant(
            name = "Bar Bar Coffe",
            visitorCount = ">2rb Pengunjung/hari",
            distance = "6 km",
            image = R.drawable.resto2
        ),
        Restaurant(
            name = "Nya.man",
            visitorCount = ">1rb Pengunjung/hari",
            distance = "22 km",
            image = R.drawable.resto3
        ),
        Restaurant(
            name = "Estafet Resto",
            visitorCount = ">1rb Pengunjung/hari",
            distance = "30 km",
            image = R.drawable.resto4
        ),
        Restaurant(
            name = "Cafe AAA",
            visitorCount = ">1rb Pengunjung/hari",
            distance = "6 km",
            image = R.drawable.resto5
        )
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(restaurants) { restaurant ->
        Card(
            modifier = Modifier
                .padding(8.dp)
                .clickable {
                    val encodeName = Uri.encode(restaurant.name)
                    navController.navigate("detail/$encodeName")
                },
            elevation = CardDefaults.cardElevation(4.dp)
        ){
            Column(
                modifier = Modifier.padding(16.dp)
            ){
                Image(
                    painter = painterResource(id = restaurant.image),
                    contentDescription = restaurant.name,
                    modifier = Modifier.size(150.dp, 100.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = restaurant.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = restaurant.visitorCount,
                    fontSize = 11.sp,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black
                )
                Text(
                    text = restaurant.distance,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
        }
    }
}}
}

@Preview(showBackground = true)
@Composable
fun PreviewFoodGridScreen() {
    FoodAppTheme {
        val navController = rememberNavController()
        RestaurantScreen(navController)
    }
}