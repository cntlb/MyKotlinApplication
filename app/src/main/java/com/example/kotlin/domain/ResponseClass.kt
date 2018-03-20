package com.example.kotlin.domain

import java.util.*


data class Coordination(
        val lon: Float,
        val lat: Float
)

data class Temperature(
        val day: Float,
        val min: Float,
        val max: Float,
        val night: Float,
        val eve: Float,
        val morn: Float
)

data class Weather(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
)

data class City(
        val id: Int,
        val name: String,
        val coord: Coordination,
        val country: String,
        val population: Int
)

data class Forecast(
        val dt: Long,
        val temp: Temperature,
        val pressure: Float,
        val humidity: Int,
        val weather: List<Weather>,
        val speed: Float,
        val deg: Int,
        val clouds: Int
)

data class ForecastResult(
        val city: City,
        val cod: String,
        val message: Float,
        val cnt: Int,
        val list: List<Forecast>
)


