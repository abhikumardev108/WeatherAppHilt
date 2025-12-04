package com.example.weatherapphilt.di

import com.example.weatherapphilt.repository.WeatherRepository
import com.example.weatherapphilt.repository.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@Module          // providers of dependencies
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds       // it tells hilt which implementation to use for an interface.
    @Singleton
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository
}