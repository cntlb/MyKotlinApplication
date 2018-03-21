package com.example.kotlin.net

import com.example.kotlin.domain.DateTypeAdapter
import com.example.kotlin.domain.ForecastResult
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset
import java.util.*
import java.util.concurrent.TimeoutException

class ForecastRequest(val zipCode: String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult{
        val conn = URL(COMPLETE_URL + zipCode).openConnection() as HttpURLConnection
        conn.connectTimeout = 5000
        conn.connect()
        if(conn.responseCode == HttpURLConnection.HTTP_OK) {
            val forecastJsonStr = conn.inputStream.use { it.readBytes() }.toString(Charsets.UTF_8)
            conn.disconnect()
            //gson字段中有Date类型的添加DateTypeAdapter即可正确解析
            //val gson = GsonBuilder().registerTypeAdapter(Date::class.java, DateTypeAdapter(1000)).create()
            val gson = Gson()
            return gson.fromJson(forecastJsonStr, ForecastResult::class.java)
        }
        conn.disconnect()
        throw TimeoutException("网络链接超时")
    }
}