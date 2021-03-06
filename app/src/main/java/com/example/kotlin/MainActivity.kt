package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.kotlin.domain.Forecast
import com.example.kotlin.domain.ForecastResult
import com.example.kotlin.domain.OnItemClickListener
import com.example.kotlin.net.ForecastRequest
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecast_list = find<RecyclerView>(R.id.forecast_list)
        forecast_list.layoutManager = LinearLayoutManager(this)

        async {
            try {
                val forecastResult = ForecastRequest("94043").execute()
                uiThread {
                    forecast_list.adapter = ForecastListAdapter(forecastResult){
                        toast(it.getDescription())
                    }
                }
            } catch (e: Exception) {
                uiThread { toast(e.message?:"Exception") }
                return@async
            }
        }
    }
}
