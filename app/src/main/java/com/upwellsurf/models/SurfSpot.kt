package com.upwellsurf.models

import java.util.UUID


 class SurfSpot(
    val name: String,
    val location: String,
    val country: String,
    val imageName: String
) {
    // Getters and setters
    val id: UUID = UUID.randomUUID()
}