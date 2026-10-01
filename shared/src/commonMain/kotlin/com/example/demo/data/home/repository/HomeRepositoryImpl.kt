package com.example.demo.data.home.repository

import com.example.demo.domain.home.repository.HomeRepository

class HomeRepositoryImpl : HomeRepository {
    override suspend fun getHome(): String = TODO("Obtener el contenido del inicio")
}
