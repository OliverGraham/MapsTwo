package com.example.mapstwo.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "parking_spot_table")
data class ParkingSpotEntity(
    val latitude: Double,
    val longitude: Double,
    @PrimaryKey val id: Int? = null
)
