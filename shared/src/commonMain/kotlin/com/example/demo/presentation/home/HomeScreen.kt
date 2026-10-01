package com.example.demo.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.demo.presentation.home.components.CalculatorSection
import com.example.demo.presentation.home.components.CatalogSection
import com.example.demo.presentation.home.components.EquipmentCategory
import com.example.demo.presentation.home.components.FooterSection
import com.example.demo.presentation.home.components.HeroSection
import com.example.demo.presentation.home.components.NavBar
import com.example.demo.presentation.home.components.QuoteModal
import com.example.demo.presentation.home.components.ServicesSection
import com.example.demo.presentation.theme.MaquicivilTheme
import com.example.demo.presentation.theme.brandBackground

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    MaquicivilTheme {
        var showQuote by remember { mutableStateOf(false) }
        var selectedName by remember { mutableStateOf<String?>(null) }
        var query by remember { mutableStateOf("") }
        var category by remember { mutableStateOf<EquipmentCategory?>(null) }

        Box(Modifier.fillMaxSize().brandBackground()) {
            Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
                Spacer(Modifier.height(72.dp))
                HeroSection(
                    onExploreClick = {},
                    onCalculatorClick = {},
                )
                CatalogSection(
                    query = query,
                    selectedCategory = category,
                    onQueryChange = { query = it },
                    onCategoryChange = { category = it },
                    onRequestQuote = {
                        selectedName = it.name
                        showQuote = true
                    },
                )
                CalculatorSection(
                    onRequestQuote = {
                        selectedName = null
                        showQuote = true
                    },
                )
                ServicesSection()
                FooterSection()
            }
            NavBar(
                onQuoteClick = {
                    selectedName = null
                    showQuote = true
                },
                modifier = Modifier.align(Alignment.TopCenter),
            )
            if (showQuote) {
                QuoteModal(
                    equipmentName = selectedName ?: "Cotización general",
                    onDismiss = { showQuote = false },
                )
            }
        }
    }
}
