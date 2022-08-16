package com.example.mapstwo.data.local

import com.example.mapstwo.domain.model.ParkingSpot


fun ParkingSpotEntity.toParkingSpot(): ParkingSpot {
    return ParkingSpot(
        latitude = latitude,
        longitude = longitude,
        id = id
    )
}


fun ParkingSpot.toParkingSpotEntity(): ParkingSpotEntity {
    return ParkingSpotEntity(
        latitude = latitude,
        longitude = longitude,
        id = id
    )
}