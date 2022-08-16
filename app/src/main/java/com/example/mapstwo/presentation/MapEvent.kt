package com.example.mapstwo.presentation

import com.example.mapstwo.domain.model.ParkingSpot
import com.google.android.gms.maps.model.LatLng

sealed class MapEvent {
    object ToggleFalloutMap: MapEvent()

    // These events interact with the database
    data class OnMapLongClick(val latLng: LatLng): MapEvent()
    data class OnInfoWindowLongClick(val spot: ParkingSpot): MapEvent()
}
