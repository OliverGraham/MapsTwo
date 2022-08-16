package com.example.mapstwo.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.MapStyleOptions

class MapsViewModel: ViewModel() {

    var state by mutableStateOf(MapState())

    fun onEvent(event: MapEvent) {
        when(event) {
            is MapEvent.ToggleFalloutMap -> {
                state = state.copy(
                    properties = state.properties.copy(
                        mapStyleOptions = if (state.isFalloutMap) MapStyleOptions(MapStyle.json)
                                          else null
                    ),
                    isFalloutMap = !state.isFalloutMap
                )
            }
            else -> {}
        }
    }
}