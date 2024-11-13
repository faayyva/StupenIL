package com.example.foodapp

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestoDetailScreen(restaurantName : String, restaurantImage : Int, navController: NavController) {
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
    { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ){
            item{
                Image(
                painter = painterResource(id = restaurantImage),
                contentDescription = "HeadingImage",
                modifier = Modifier.size(350.dp, 250.dp))
            }
            item{
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp),
                    elevation = CardDefaults.cardElevation(2.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    border = BorderStroke(1.dp, Color.Black)
                ){
                    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                        Text(text = "Alamat",  style = MaterialTheme.typography.titleMedium)
                        Text(text = "Jalan Karya No 23, Lubuk Buaya, Kec. Tampan, Kota Padang, Sumatera Barat",
                            style = MaterialTheme.typography.bodySmall)

                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewRestoDetailScreen(){
    RestoDetailScreen(restaurantName = "RM", restaurantImage = R.drawable.resto4, navController = rememberNavController())
}