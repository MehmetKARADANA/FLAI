package com.mobile.flai.domain

import com.mobile.flai.data.MCPRepository
import javax.inject.Inject

class GetFlightInfoUseCase @Inject constructor(
    private val repository: MCPRepository
) {
    suspend operator fun invoke(query: String): FlightInfo {
        val response = repository.getFlightInfo(query)
        return FlightInfo(
            answer = response.answer,
            gate = response.gate,
            delayStatus = response.delayStatus,
            boardingTime = response.boardingTime
        )
    }
}
