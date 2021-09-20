package com.macamp.paperstock.data.api

interface ServiceProvider<T> {
    val service: T
}