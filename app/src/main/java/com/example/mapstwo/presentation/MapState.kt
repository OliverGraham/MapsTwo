package com.example.mapstwo.presentation

import com.example.mapstwo.domain.model.ParkingSpot
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties

data class MapState(
    val properties: MapProperties = MapProperties(
        // for reference
        // mapStyleOptions = MapStyleOptions.loadRawResourceStyle()
        mapStyleOptions = MapStyleOptions(MapStyle.json)
    ),
    val parkingSpots: List<ParkingSpot> = emptyList(),
    val isFalloutMap: Boolean = false
)