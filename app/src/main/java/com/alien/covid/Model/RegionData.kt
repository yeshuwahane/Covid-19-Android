package com.alien.covid.Model

data class RegionData(
    val activeCases: Int,
    val deceased: Int,
    val newDeceased: Int,
    val newInfected: Int,
    val newRecovered: Int,
    val recovered: Int,
    val region: String,
    val totalInfected: Int
)