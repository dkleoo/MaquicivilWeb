package com.example.demo.domain.home.usecase

import com.example.demo.domain.home.repository.HomeRepository

class GetHomeUseCase(
    private val repository: HomeRepository,
) {
    suspend operator fun invoke(): String = TODO("Delegar al repositorio")
}
