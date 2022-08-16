package com.example.mapstwo.dependency_injection

import android.app.Application
import androidx.room.Room
import com.example.mapstwo.data.local.ParkingSpotDatabase
import com.example.mapstwo.data.local.ParkingSpotRepositoryImplementation
import com.example.mapstwo.domain.repository.ParkingSpotRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideParkingSpotDatabase(app: Application): ParkingSpotDatabase {
        return Room.databaseBuilder(
            app,
            ParkingSpotDatabase::class.java,
            "parking_spots_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideParkingSpotRepository(db: ParkingSpotDatabase): ParkingSpotRepository {
        return ParkingSpotRepositoryImplementation(db.dao)
    }
}