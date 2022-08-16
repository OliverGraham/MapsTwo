package com.example.mapstwo.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker

@Composable
fun MapScreen(
    mapsViewModel: MapsViewModel = viewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val uiSettings = remember {
        MapUiSettings(zoomControlsEnabled = false)
    }
    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton =  {
            FloatingActionButton(onClick = {
                mapsViewModel.onEvent(MapEvent.ToggleFalloutMap)
            }) {
                Icon(imageVector = if(mapsViewModel.state.isFalloutMap) {
                Icons.Default.ToggleOff
                } else Icons.Default.ToggleOn,
                    contentDescription = "Toggle Fallout map"
                )
            }
        }
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            properties = mapsViewModel.state.properties,
            uiSettings = uiSettings,
            onMapLongClick = { latLng ->
                mapsViewModel.onEvent(MapEvent.OnMapLongClick(latLng))
            }
        ) {
            // show markers on map
            mapsViewModel.state.parkingSpots.forEach { spot ->
                val latitude = spot.latitude
                val longitude = spot.longitude
                Marker(
                    position = LatLng(latitude, longitude),
                    title = "Parking spot ($latitude, $longitude)",
                    snippet = "Long click to delete",
                    onInfoWindowLongClick = {
                        mapsViewModel.onEvent(
                            MapEvent.OnInfoWindowLongClick(spot)
                        )
                    },
                    onClick = { marker ->
                        marker.showInfoWindow()
                        true
                    },
                    // change other parts of the marker; color, icon
                    icon = BitmapDescriptorFactory.defaultMarker(
                        BitmapDescriptorFactory.HUE_AZURE
                    )
                )
            }
        }
    }
}
