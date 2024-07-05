package com.upwellsurf.models

import java.util.UUID


// Define the SurfSpotForecast class
class SurfSpotForecast(
    val spotName: String,
    val forecast: String,
    val buoyReport: String,
    val latitude: Double,
    val longitude: Double
) {
    // Getters and setters
    val id: UUID = UUID.randomUUID()
}