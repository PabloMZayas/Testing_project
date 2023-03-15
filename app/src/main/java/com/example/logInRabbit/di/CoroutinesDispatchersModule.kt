package com.example.logInRabbit.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CoroutinesDispatchersModule {

    @Provides
    fun provideCoroutinesDispatchers() = CoroutinesDispatchers()
}
