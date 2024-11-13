package com.example.foodapp

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodapp.ui.theme.FoodAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailRestoScreen(restaurantName : String, navController: NavController) {
    val decodedName = Uri.decode(restaurantName)
    Scaffold(
        topBar = {
        TopAppBar(
        title = {
            Text(text = decodedName, fontWeight = FontWeight.Bold)
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack("resto_grid", inclusive = false)
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.LightGray
        ),
        modifier = Modifier.fillMaxWidth()
    )})
    {padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.lamunombak),
                    contentDescription = "HeadingImage",
                    modifier = Modifier.size(350.dp, 250.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                        Text(text = "Alamat", style = TextStyle(fontWeight = FontWeight.Bold))
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Jalan Karya No 23, Lubuk Buaya, Kec. Tampan, Kota Padang, Sumatera Barat",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "Location", Modifier.size(16.dp))
                            Text(text = "13 km", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                        Text(text = "Deskripsi", style = TextStyle(fontWeight = FontWeight.Bold))
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Rumah Makan Khas Sumatera Barat yang menyajikan makanan khas Sumatera Barat. Salah satu rumah makan favorit yang dikunungi para wisatawan.",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                        Text(text = "Menu Favorit", style = TextStyle(fontWeight = FontWeight.Bold))
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            MenuItemCard(imageRes = R.drawable.sate, name = "Sate")
                            MenuItemCard(imageRes = R.drawable.rendang, name = "Rendang")
                            MenuItemCard(imageRes = R.drawable.nasi_goreng, name = "Nasi Goreng")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                        Text(text = "Rating", style = TextStyle(fontWeight = FontWeight.Bold))
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.Star, contentDescription = "Star")
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(text = "4.5/5.0", style = TextStyle(fontWeight = FontWeight.Bold))
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(text = "2,300 Pengunjung", style = TextStyle(fontWeight = FontWeight.Bold))
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

    }
}
@Composable
fun MenuItemCard(imageRes: Int, name: String) {
    Column(
        modifier = Modifier.size(100.dp, 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "$name Image",
            modifier = Modifier.size(100.dp).clip(RoundedCornerShape(10.dp))
        )
        Text(text = name, style = MaterialTheme.typography.bodySmall)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailRestoScreen() {
    FoodAppTheme {
        val navController = rememberNavController()
        DetailRestoScreen(restaurantName = "RM Lamun Ombak", navController = navController)
    }
}