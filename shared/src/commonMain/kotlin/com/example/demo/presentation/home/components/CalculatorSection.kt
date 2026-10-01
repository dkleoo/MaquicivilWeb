package com.example.demo.presentation.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo.presentation.theme.BorderSubtle
import com.example.demo.presentation.theme.BrandAmber
import com.example.demo.presentation.theme.BrandOrange
import com.example.demo.presentation.theme.OnDark
import com.example.demo.presentation.theme.SuccessGreen
import com.example.demo.presentation.theme.SurfaceInput
import com.example.demo.presentation.theme.SurfacePanel
import com.example.demo.presentation.theme.TextSecondary

@Composable
fun CalculatorSection(onRequestQuote: () -> Unit) {
    var selected by remember { mutableStateOf(sampleEquipment[0]) }
    var days by remember { mutableStateOf(7f) }
    var withOperator by remember { mutableStateOf(false) }
    var withTransport by remember { mutableStateOf(false) }

    val dailyRate = selected.dailyPriceUsd + if (withOperator) 80 else 0
    val subtotal = (dailyRate * days.toInt()).toDouble()
    val discount = if (days >= 30f) 0.20 else if (days >= 7f) 0.10 else 0.0
    val total = (subtotal * (1 - discount)).toInt() + if (withTransport) 150 else 0

    Column(Modifier.fillMaxWidth().padding(horizontal = 32.dp, vertical = 32.dp)) {
        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = SurfacePanel),
            border = BorderStroke(1.dp, BorderSubtle),
        ) {
            Column(Modifier.padding(24.dp)) {
                Text("Cotizador Estimado", color = BrandAmber, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Text("Calcula el Costo Aproximado de Alquiler", color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 24.sp)
                Spacer(Modifier.height(16.dp))
                Text("Seleccionar Equipo", color = TextSecondary, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(8.dp))
                sampleEquipment.chunked(3).forEach { rowItems ->
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        rowItems.forEach { item ->
                            Button(
                                onClick = { selected = item },
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (selected == item) BrandOrange else SurfaceInput,
                                    contentColor = if (selected == item) Color.Black else TextSecondary,
                                ),
                            ) {
                                Text(item.name, fontSize = 10.sp, maxLines = 1)
                            }
                        }
                        repeat(3 - rowItems.size) { Spacer(Modifier.weight(1f)) }
                    }
                    Spacer(Modifier.height(8.dp))
                }
                Spacer(Modifier.height(12.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Días de Alquiler", color = TextSecondary, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                    Text(days.toInt().toString() + " Días", color = BrandOrange, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
                Slider(value = days, onValueChange = { days = it }, valueRange = 1f..60f)
                Spacer(Modifier.height(8.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Row(Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = withOperator, onCheckedChange = { withOperator = it })
                        Text("Operador (+$80/día)", color = OnDark, fontSize = 12.sp)
                    }
                    Row(Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = withTransport, onCheckedChange = { withTransport = it })
                        Text("Transporte (+$150)", color = OnDark, fontSize = 12.sp)
                    }
                }
                Spacer(Modifier.height(16.dp))
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        Text("Total Estimado", color = TextSecondary, fontSize = 12.sp)
                        Text("$" + total + " USD", color = Color.White, fontWeight = FontWeight.Black, fontSize = 28.sp)
                        if (discount > 0) {
                            Text("Descuento aplicado " + (discount * 100).toInt() + "%", color = SuccessGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                    Button(
                        onClick = onRequestQuote,
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = BrandOrange, contentColor = Color.Black),
                    ) {
                        Text("Solicitud Directa", fontWeight = FontWeight.ExtraBold)
                    }
                }
            }
        }
    }
}
