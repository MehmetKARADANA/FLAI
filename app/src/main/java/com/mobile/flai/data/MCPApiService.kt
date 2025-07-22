package com.mobile.flai.data

import retrofit2.http.Body
import retrofit2.http.POST

interface MCPApiService {
    @POST("mcp/query")
    suspend fun query(@Body request: MCPRequest): MCPResponse
}
