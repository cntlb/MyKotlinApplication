package com.example.kotlin.domain

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.util.*

/**
 * @author Linbing Tang
 * @since 18-3-20.
 */
class DateTypeAdapter(val fac:Long = 1) : TypeAdapter<Date>() {
    override fun write(out: JsonWriter, value: Date) {
        out.value(value.time/fac)
    }

    override fun read(`in`: JsonReader): Date {
        return Date(`in`.nextLong()*fac)
    }
}