package com.example.mapstwo.data.local

import com.example.mapstwo.domain.model.ParkingSpot
import com.example.mapstwo.domain.repository.ParkingSpotRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ParkingSpotRepositoryImplementation(
    private val dao: ParkingSpotDao
): ParkingSpotRepository {
    override suspend fun insertParkingSpot(spot: ParkingSpot) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteParkingSpot(spot: ParkingSpot) {
        TODO("Not yet implemented")
    }

    override fun getParkingSpots(): Flow<List<ParkingSpot>> {
        return dao.getParkingSpots().map { spots ->
            spots.map { it.toParkingSpot() }
        }
    }
}