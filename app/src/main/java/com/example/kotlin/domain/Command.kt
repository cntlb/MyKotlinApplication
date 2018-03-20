package com.example.kotlin.domain

/**
 * @author Linbing Tang
 * @since 18-3-20.
 */
interface Command<T>{
    fun execute():T
}