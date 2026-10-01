package com.example.demo.presentation.home.components

enum class EquipmentCategory(val label: String) {
    PESADA("Maquinaria Pesada"),
    ELEVACION("Elevación y Manlift"),
    COMPACTACION("Compactación y Viales"),
    LOGISTICA("Carga y Logística"),
}

data class EquipmentUi(
    val id: Int,
    val name: String,
    val category: EquipmentCategory,
    val type: String,
    val dailyPriceUsd: Int,
    val specs: Map<String, String>,
    val tag: String,
)

val sampleEquipment: List<EquipmentUi> = listOf(
    EquipmentUi(
        id = 1,
        name = "Caterpillar 320 Next Gen",
        category = EquipmentCategory.PESADA,
        type = "Excavadora Hidráulica",
        dailyPriceUsd = 350,
        specs = mapOf("Peso" to "22.5 Ton", "Balde" to "1.2 m³", "Potencia" to "174 HP"),
        tag = "Maquicivil Oficial",
    ),
    EquipmentUi(
        id = 2,
        name = "Caterpillar D6T",
        category = EquipmentCategory.PESADA,
        type = "Bulldozer sobre Orugas",
        dailyPriceUsd = 420,
        specs = mapOf("Peso" to "21.0 Ton", "Hoja" to "3.8 m³", "Potencia" to "215 HP"),
        tag = "Flota de Oruga",
    ),
    EquipmentUi(
        id = 3,
        name = "JCB 3CX Eco",
        category = EquipmentCategory.PESADA,
        type = "Retroexcavadora 4x4",
        dailyPriceUsd = 250,
        specs = mapOf("Peso" to "8.1 Ton", "Profundidad" to "4.37 m", "Potencia" to "92 HP"),
        tag = "Multipropósito",
    ),
    EquipmentUi(
        id = 4,
        name = "JLG 600S Telescopic",
        category = EquipmentCategory.ELEVACION,
        type = "Manlift Telescópico",
        dailyPriceUsd = 180,
        specs = mapOf("Altura" to "20.3 m", "Alcance" to "15.2 m", "Capacidad" to "270 kg"),
        tag = "Trabajos en Altura",
    ),
    EquipmentUi(
        id = 5,
        name = "Genie GS-1930",
        category = EquipmentCategory.ELEVACION,
        type = "Plataforma de Tijera",
        dailyPriceUsd = 110,
        specs = mapOf("Altura" to "7.8 m", "Ancho" to "0.76 m", "Capacidad" to "227 kg"),
        tag = "Trabajos en Altura",
    ),
    EquipmentUi(
        id = 6,
        name = "Hamm HD 12 VV",
        category = EquipmentCategory.COMPACTACION,
        type = "Rodillo Compactador",
        dailyPriceUsd = 150,
        specs = mapOf("Peso" to "2.7 Ton", "Ancho" to "1.20 m", "Fuerza" to "42 kN"),
        tag = "Pavimentación",
    ),
    EquipmentUi(
        id = 7,
        name = "Toyota Tonero 3.0T",
        category = EquipmentCategory.LOGISTICA,
        type = "Montacargas Diésel",
        dailyPriceUsd = 120,
        specs = mapOf("Capacidad" to "3.0 Ton", "Altura" to "4.5 m", "Motor" to "Toyota"),
        tag = "Carga y Logística",
    ),
)
