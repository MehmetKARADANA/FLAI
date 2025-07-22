package com.mobile.flai.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.flai.domain.FlightInfo
import com.mobile.flai.domain.GetFlightInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val getFlightInfoUseCase: GetFlightInfoUseCase
) : ViewModel() {

    var state by mutableStateOf<FlightInfo?>(null)
        private set

    fun onQuerySubmit(query: String) {
        viewModelScope.launch {
            try {
                state = getFlightInfoUseCase(query)
            } catch (e: Exception) {
                Log.e("ChatViewModel", "API çağrısı sırasında hata oluştu "+e.message)
            }
        }
    }
}
