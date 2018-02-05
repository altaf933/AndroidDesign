package com.di

import com.api.ApiRepository
import com.api.ApiServices
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by altafshaikh on 01/02/18.
 */

@Module
class NetworkModule {

    @Provides
    fun okHttpClient(okHttpClient: OkHttpClient): OkHttpClient {
        return OkHttpClient.Builder()
                .build()
    }

    @Provides
    fun retrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
    }

    @Singleton
    @Provides
    fun apiServices(retrofit: Retrofit) =
            retrofit.create(ApiServices::class.java)

    fun provideApiRepository(apiServices: ApiServices) {
        ApiRepository(apiServices)
    }

}