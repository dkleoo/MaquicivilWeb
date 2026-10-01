package com.example.demo.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.demo.data.home.repository.HomeRepositoryImpl
import com.example.demo.domain.home.usecase.GetHomeUseCase
import com.example.demo.presentation.home.HomeScreen
import com.example.demo.presentation.home.HomeViewModel

@Composable
fun App() {
    val viewModel = remember { HomeViewModel(GetHomeUseCase(HomeRepositoryImpl())) }
    HomeScreen(viewModel)
}
