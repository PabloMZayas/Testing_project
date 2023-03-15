package com.example.logInRabbit.di

import android.content.Context
import androidx.room.Room
import com.example.logInRabbit.RabbitApplication_HiltComponents.SingletonC
import com.example.logInRabbit.data.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserDao {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context) = Room.databaseBuilder(context, AppDataBase::class.java, "myDataBase").build()

    @Singleton
    @Provides
    fun provideUserDao(dataBase: AppDataBase) = dataBase.getUserDao()
}