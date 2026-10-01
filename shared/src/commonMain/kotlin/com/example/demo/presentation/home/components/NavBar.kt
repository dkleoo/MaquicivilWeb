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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo.presentation.theme.BorderSubtle
import com.example.demo.presentation.theme.BrandAmber
import com.example.demo.presentation.theme.BrandOrange
import com.example.demo.presentation.theme.TextSecondary

@Composable
fun NavBar(onQuoteClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .background(Color.Black.copy(alpha = 0.45f)),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Brush.linearGradient(listOf(BrandOrange, BrandAmber))),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("MC", color = Color.Black, fontWeight = FontWeight.Black, fontSize = 12.sp)
                }
                Spacer(Modifier.width(10.dp))
                Column {
                    Text("MAQUICIVIL", color = Color.White, fontWeight = FontWeight.Black, fontSize = 15.sp, lineHeight = 15.sp)
                    Text("INGENIEROS S.A.S", color = BrandOrange, fontWeight = FontWeight.Bold, fontSize = 9.sp, letterSpacing = 1.5.sp)
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                listOf("Inicio", "Maquinaria", "Cotizador", "Servicios", "Nosotros").forEach { link ->
                    Text(
                        text = link,
                        color = TextSecondary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(horizontal = 10.dp),
                    )
                }
            }
            Button(
                onClick = onQuoteClick,
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BrandOrange, contentColor = Color.Black),
            ) {
                Text("Cotizar Ahora", fontWeight = FontWeight.ExtraBold, fontSize = 12.sp)
            }
        }
        Box(Modifier.fillMaxWidth().height(1.dp).background(BorderSubtle))
    }
}
