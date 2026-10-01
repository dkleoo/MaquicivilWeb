package com.example.demo.presentation.home.components

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo.presentation.theme.BrandAmber
import com.example.demo.presentation.theme.BrandDark
import com.example.demo.presentation.theme.BrandOrange
import com.example.demo.presentation.theme.BrandYellow
import com.example.demo.presentation.theme.OnDark
import com.example.demo.presentation.theme.OrangeSoft
import com.example.demo.presentation.theme.SurfaceElevated
import com.example.demo.presentation.theme.SurfacePanel
import com.example.demo.presentation.theme.TextSecondary

@Composable
fun HeroSection(onExploreClick: () -> Unit, onCalculatorClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp, vertical = 40.dp),
        horizontalArrangement = Arrangement.spacedBy(32.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(Modifier.weight(1.1f)) {
            Box(
                Modifier
                    .clip(RoundedCornerShape(50))
                    .background(OrangeSoft)
                    .padding(horizontal = 12.dp, vertical = 6.dp),
            ) {
                Text("Infraestructura & Malla Vial", color = BrandOrange, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
            }
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Empresa de Maquinaria Pesada & Volquetas",
                style = TextStyle(
                    brush = Brush.linearGradient(listOf(BrandOrange, BrandAmber, BrandYellow)),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Black,
                ),
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Especializados en la reparación y construcción de la malla vial. Alquilamos y construimos con la máxima calidad, potencia y compromiso en toda Colombia.",
                color = TextSecondary,
                fontSize = 14.sp,
            )
            Spacer(Modifier.height(24.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(
                    onClick = onExploreClick,
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BrandOrange, contentColor = Color.Black),
                ) {
                    Text("Explorar Catálogo", fontWeight = FontWeight.ExtraBold)
                }
                Button(
                    onClick = onCalculatorClick,
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = SurfaceElevated, contentColor = OnDark),
                ) {
                    Text("Calculadora en Línea", fontWeight = FontWeight.Bold)
                }
            }
            Spacer(Modifier.height(28.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                Metric("+15", "Años de Experiencia", Modifier.weight(1f))
                Metric("+500", "Obras Completadas", Modifier.weight(1f))
                Metric("24/7", "Soporte Mecánico", Modifier.weight(1f))
            }
        }
        FeaturedCarousel(Modifier.weight(0.9f))
    }
}

@Composable
private fun Metric(value: String, label: String, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(value, color = Color.White, fontWeight = FontWeight.Black, fontSize = 24.sp)
        Text(label, color = TextSecondary, fontSize = 11.sp)
    }
}

@Composable
private fun FeaturedCarousel(modifier: Modifier = Modifier) {
    var index by remember { mutableStateOf(0) }
    val item = sampleEquipment[index]
    Column(modifier) {
        Column(
            Modifier.fillMaxWidth().clip(RoundedCornerShape(24.dp)).background(SurfacePanel),
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .background(Brush.linearGradient(listOf(SurfaceElevated, BrandDark))),
                contentAlignment = Alignment.Center,
            ) {
                Text(item.name.take(1), color = BrandOrange, fontSize = 64.sp, fontWeight = FontWeight.Black)
            }
            Column(Modifier.padding(16.dp)) {
                Text(item.tag, color = BrandOrange, fontWeight = FontWeight.Bold, fontSize = 10.sp, letterSpacing = 1.sp)
                Spacer(Modifier.height(4.dp))
                Text(item.name, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(item.type + " | $" + item.dailyPriceUsd + " USD/día", color = TextSecondary, fontSize = 12.sp)
            }
        }
        Spacer(Modifier.height(12.dp))
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = { index = if (index == 0) sampleEquipment.size - 1 else index - 1 },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = SurfaceElevated, contentColor = OnDark),
            ) {
                Text("Anterior", fontSize = 12.sp)
            }
            Button(
                onClick = { index = (index + 1) % sampleEquipment.size },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BrandOrange, contentColor = Color.Black),
            ) {
                Text("Siguiente", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
