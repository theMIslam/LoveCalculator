package com.example.lovecalculator

import android.content.Context
import androidx.room.Room
import com.example.lovecalculator.remote.LoveApi
import com.example.lovecalculator.room.AppDataBase
import com.example.lovecalculator.room.LoveDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(LoveApi::class.java)
    }
    @Provides
    fun provideHelper():Helper{
        return Helper()
    }
    @Singleton
    @Provides
    fun providePrefs(@ApplicationContext context: Context):Prefs{
        return Prefs(context)
    }


    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext app:Context):AppDataBase=
        Room.databaseBuilder(app, AppDataBase::class.java,"history")
            .allowMainThreadQueries().fallbackToDestructiveMigration().build()
    @Singleton
    @Provides
    fun provideHistoryDao(appDataBase:AppDataBase): LoveDao {
        return  appDataBase.loveDao()
    }
}