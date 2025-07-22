package com.mobile.flai.data

interface MCPRepository {
    suspend fun getFlightInfo(query: String): MCPResponse
}
