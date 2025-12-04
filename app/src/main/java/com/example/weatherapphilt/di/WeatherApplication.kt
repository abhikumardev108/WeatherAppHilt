package com.example.weatherapphilt.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp




// custom app class that hilt uses to create
// the app-wide dependency graph.

@HiltAndroidApp
class WeatherApplication: Application()


// @HiltAndroidApp  -->
// 1. Triggers hilt's code generation at compile time.
// 2. Create DI container at the app level.
// 3. makes hilt aware of your app's lifecycle.
