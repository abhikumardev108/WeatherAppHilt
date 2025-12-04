package com.example.weatherapphilt.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapphilt.model.WeatherInfo


@Composable
fun WeatherInfoDisplay(weatherInfo: WeatherInfo) {

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color.Blue)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Place,
                    contentDescription = "place"
                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = weatherInfo.location,
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "${weatherInfo.temperature} °C",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            if(weatherInfo.temperature > 30) {
                Text(
                    text = weatherInfo.description,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Red
                )
            } else if(weatherInfo.temperature >= 20 && weatherInfo.temperature < 30){
                Text(
                    text = weatherInfo.description,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Magenta
                )
            } else {
                Text(
                    text = weatherInfo.description,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Blue
                )
            }
        }
    }
}