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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo.presentation.theme.BorderSubtle
import com.example.demo.presentation.theme.BrandOrange
import com.example.demo.presentation.theme.SurfacePanel
import com.example.demo.presentation.theme.TextSecondary

private data class ServiceUi(val title: String, val description: String)

private val sampleServices = listOf(
    ServiceUi("Mantenimiento Riguroso", "Revisión mecánica periódica de motores, sistemas hidráulicos y orugas en cada equipo."),
    ServiceUi("Despacho Puntual", "Logística propia en cama baja para transporte express a frentes de obra urbanos y rurales."),
    ServiceUi("Operadores Calificados", "Personal con certificación SISO y amplia trayectoria en obras civiles e infraestructura."),
    ServiceUi("Asistencia en Campo", "Taller móvil disponible para resolver imprevistos técnicos rápidamente sin retrasar la obra."),
)

@Composable
fun ServicesSection() {
    Column(Modifier.fillMaxWidth().padding(horizontal = 32.dp, vertical = 32.dp)) {
        Text("Maquicivil Ingenieros", color = BrandOrange, fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Text("Servicios y Respaldo Operacional", color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 24.sp)
        Spacer(Modifier.height(16.dp))
        sampleServices.chunked(2).forEach { rowItems ->
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                rowItems.forEach { service ->
                    Card(
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = SurfacePanel),
                        border = BorderStroke(1.dp, BorderSubtle),
                    ) {
                        Column(Modifier.padding(20.dp)) {
                            Text(service.title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Spacer(Modifier.height(8.dp))
                            Text(service.description, color = TextSecondary, fontSize = 12.sp)
                        }
                    }
                }
                repeat(2 - rowItems.size) { Spacer(Modifier.weight(1f)) }
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}
