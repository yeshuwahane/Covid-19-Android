package com.alien.covid.Model

data class CovidResponse(
    val activeCases: Int,
    val activeCasesNew: Int,
    val deaths: Int,
    val deathsNew: Int,
    val lastUpdatedAtApify: String,
    val previousDayTests: Int,
    val readMe: String,
    val recovered: Int,
    val recoveredNew: Int,
    val regionData: List<RegionData>,
    val sourceUrl: String,
    val totalCases: Int
)