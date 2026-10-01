package com.example.demo.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.demo.domain.home.usecase.GetHomeUseCase

class HomeViewModel(
    private val getHome: GetHomeUseCase,
) : ViewModel() {

    var content by mutableStateOf("")
        private set
}
