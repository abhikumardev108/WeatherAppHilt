package com.example.weatherapphilt.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.weatherapphilt.viewmodel.WeatherUiState
import com.example.weatherapphilt.viewmodel.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(viewModel: WeatherViewModel = hiltViewModel()) {

    val uiState by viewModel.uiState.collectAsState()
    val locations by viewModel.locations.collectAsState()
    val selectedLocation by viewModel.selectedLocation.collectAsState()



    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Weather App with Hilt")
                }
            )
        },
    ) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LocationSelector(
                locations = locations,
                selectedLocation = selectedLocation,  // current value.
                onLocationSelected = { newLocation ->
                    viewModel.selectedLocation(newLocation)
                }
            )

            Spacer(modifier = Modifier.height(40.dp))


            // weather display based on Ui state
            when(val state  = uiState) {
                WeatherUiState.IsLoading -> {
                    CircularProgressIndicator()
                }
                is WeatherUiState.IsSuccess -> {
                    WeatherInfoDisplay(weatherInfo = state.weatherInfo)
                }
                is WeatherUiState.IsError -> {
                    Text(
                        text = state.errorMessage,
                        color = Color.Red
                    )
                }
            }
        }
    }
}