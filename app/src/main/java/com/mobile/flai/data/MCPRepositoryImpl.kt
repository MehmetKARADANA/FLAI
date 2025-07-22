package com.mobile.flai.data

import javax.inject.Inject

class MCPRepositoryImpl @Inject constructor(
    private val api: MCPApiService
) : MCPRepository {
    override suspend fun getFlightInfo(query: String): MCPResponse {
        return api.query(MCPRequest(userQuery = query))
    }
}
