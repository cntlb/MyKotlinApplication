package com.example.kotlin

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.kotlin.domain.Forecast
import java.text.SimpleDateFormat
import java.util.*

class ForecastListAdapter(val items: List<Forecast>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(items[position]) {
            val dateStr = SimpleDateFormat("yyyy.MM.dd", Locale.CHINA).format(Date(dt * 1000))
            holder.textView.text = "$dateStr-${weather[0].description}-${temp.max}/${temp.min}"
        }
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}