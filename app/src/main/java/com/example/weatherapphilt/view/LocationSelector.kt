package com.example.weatherapphilt.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun LocationSelector(
    locations: List<String>,
    selectedLocation: String,
    onLocationSelected: (String) -> Unit
) {


    Column(modifier = Modifier.padding(12.dp)) {
        Text(
            text = "Select a location",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(8.dp)
        )


        locations.forEach { singleLocation ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = singleLocation == selectedLocation,
                        onClick = {
                            onLocationSelected(singleLocation)
                        }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                RadioButton(
                    selected = singleLocation == selectedLocation,
                    onClick = {
                        onLocationSelected(singleLocation)
                    }
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(text = singleLocation)
            }
        }
    }
}