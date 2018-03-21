package com.example.kotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.kotlin.domain.*
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

class ForecastListAdapter(private val result: ForecastResult) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun getItemCount(): Int = result.list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.app_item_recycle_forecast, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(result[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        @BindView(R.id.icon) lateinit var icon:ImageView
        @BindView(R.id.date) lateinit var date:TextView
        @BindView(R.id.description) lateinit var description:TextView
        @BindView(R.id.maxTemperature) lateinit var maxTemperature:TextView
        @BindView(R.id.minTemperature) lateinit var minTemperature:TextView

        init {
            ButterKnife.bind(this, view)
        }

        fun bindForecast(forecast: Forecast){
            with(forecast){
                description.text = getDescription()
                date.text = SimpleDateFormat("yyyy.MM.dd", Locale.CHINA).format(Date(dt * 1000))
                maxTemperature.text = "${temp.max.toInt()}°"
                minTemperature.text = "${temp.min.toInt()}°"
                Picasso.with(itemView.context).load(getIconUrl()).into(icon)
            }
        }
    }
}