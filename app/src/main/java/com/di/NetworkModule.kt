package com.di

import com.api.ApiServices
import com.api.response.ApplicationJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.time.LocalDateTime
import javax.inject.Singleton

/**
 * Created by altafshaikh on 01/02/18.
 */

@Module
class NetworkModule {

    @Provides
    fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .build()
    }

    @Provides
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder()
                        .add(ApplicationJsonAdapterFactory.INSTANCE).add(LocalDateTime::class.java)
                        .build()))
                .build()
    }
    @Singleton
    @Provides
    fun apiServices(retrofit: Retrofit) =
            retrofit.create(ApiServices::class.java)

}