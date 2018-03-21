package com.example.kotlin.domain


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

////拓展属性不是字段,因此没有backing field,不能有初始化器
//val Forecast.description:String
//        get() = weather[0].description

data class ForecastResult(
        val city: City,
        val cod: String,
        val message: Float,
        val cnt: Int,
        val list: List<Forecast>
) {
    operator fun get(i: Int): Forecast = list[i]
}


