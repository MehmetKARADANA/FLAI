package com.mobile.flai.data

data class MCPResponse(
    val answer: String,
    val intent: String?,
    val flightNumber: String?,
    val gate: String?,
    val delayStatus: String?,
    val boardingTime: String?
)
