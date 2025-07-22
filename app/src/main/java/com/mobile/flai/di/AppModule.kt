package com.mobile.flai.di

import com.mobile.flai.data.MCPApiService
import com.mobile.flai.data.MCPRepositoryImpl
import com.mobile.flai.data.MCPRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideMCPApiService(): MCPApiService {
        return Retrofit.Builder()
            .baseUrl("https://mcp.turkishtechlab.com/")
             .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MCPApiService::class.java)
    }

    @Provides
    fun provideRepository(api: MCPApiService): MCPRepository {
        return MCPRepositoryImpl(api)
    }
}
