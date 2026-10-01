package com.example.demo.domain.home.repository

interface HomeRepository {
    suspend fun getHome(): String
}
