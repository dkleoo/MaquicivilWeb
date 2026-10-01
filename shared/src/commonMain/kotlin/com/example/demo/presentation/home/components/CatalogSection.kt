package com.example.demo.presentation.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo.presentation.theme.BorderSubtle
import com.example.demo.presentation.theme.BrandAmber
import com.example.demo.presentation.theme.BrandOrange
import com.example.demo.presentation.theme.OnDark
import com.example.demo.presentation.theme.SurfaceElevated
import com.example.demo.presentation.theme.SurfaceInput
import com.example.demo.presentation.theme.SurfacePanel
import com.example.demo.presentation.theme.TextMuted
import com.example.demo.presentation.theme.TextSecondary

@Composable
fun CatalogSection(
    query: String,
    selectedCategory: EquipmentCategory?,
    onQueryChange: (String) -> Unit,
    onCategoryChange: (EquipmentCategory?) -> Unit,
    onRequestQuote: (EquipmentUi) -> Unit,
) {
    val filtered = sampleEquipment.filter { item ->
        val matchesCategory = selectedCategory == null || item.category == selectedCategory
        val matchesQuery = query.isBlank() ||
            item.name.contains(query, ignoreCase = true) ||
            item.type.contains(query, ignoreCase = true)
        matchesCategory && matchesQuery
    }

    Column(Modifier.fillMaxWidth().padding(horizontal = 32.dp, vertical = 32.dp)) {
        Text("Maquicivil Ingenieros", color = BrandOrange, fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Text("Catálogo de Maquinaria", color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 28.sp)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            singleLine = true,
            placeholder = { Text("Buscar por equipo, modelo...") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CategoryButton("Todos los Equipos", selectedCategory == null) { onCategoryChange(null) }
            EquipmentCategory.entries.forEach { category ->
                CategoryButton(category.label, selectedCategory == category) { onCategoryChange(category) }
            }
        }
        Spacer(Modifier.height(24.dp))
        if (filtered.isEmpty()) {
            Text("No se encontraron equipos", color = TextSecondary)
        } else {
            filtered.chunked(3).forEach { rowItems ->
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    rowItems.forEach { item ->
                        EquipmentCard(item, Modifier.weight(1f)) { onRequestQuote(item) }
                    }
                    repeat(3 - rowItems.size) { Spacer(Modifier.weight(1f)) }
                }
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun CategoryButton(label: String, selected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) BrandOrange else SurfacePanel,
            contentColor = if (selected) Color.Black else TextSecondary,
        ),
    ) {
        Text(label, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun EquipmentCard(item: EquipmentUi, modifier: Modifier = Modifier, onRequestQuote: () -> Unit) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = SurfacePanel),
        border = BorderStroke(1.dp, BorderSubtle),
    ) {
        Column(Modifier.padding(16.dp)) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(SurfaceElevated),
                contentAlignment = Alignment.Center,
            ) {
                Text(item.name.take(1), color = BrandOrange, fontWeight = FontWeight.Black, fontSize = 32.sp)
            }
            Spacer(Modifier.height(12.dp))
            Text(item.type.uppercase(), color = BrandOrange, fontWeight = FontWeight.Bold, fontSize = 10.sp)
            Text(item.name, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Spacer(Modifier.height(8.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                item.specs.entries.take(3).forEach { (key, value) ->
                    Column(
                        Modifier.weight(1f).clip(RoundedCornerShape(8.dp)).background(SurfaceInput).padding(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(key.uppercase(), color = TextMuted, fontSize = 8.sp, fontWeight = FontWeight.SemiBold)
                        Text(value, color = OnDark, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
            Spacer(Modifier.height(12.dp))
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Text("$" + item.dailyPriceUsd + " USD", color = BrandAmber, fontWeight = FontWeight.Black, fontSize = 14.sp)
                Button(
                    onClick = onRequestQuote,
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = SurfaceElevated, contentColor = OnDark),
                ) {
                    Text("Solicitar", fontSize = 11.sp)
                }
            }
        }
    }
}
