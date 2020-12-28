package com.a360celsius.basicstock.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.a360celsius.basicstock.data.db.dao.CompaniesTickerDao
import com.a360celsius.basicstock.data.db.entities.AllCompaniesTickerEntity

@Database(
        entities = [AllCompaniesTickerEntity::class],
        version = 1
)

abstract class DataBase: RoomDatabase() {

    abstract fun getAllCompaniesTickerDao(): CompaniesTickerDao


    companion object{

        @Volatile
        private var instance: DataBase? = null
        private val LOCK = Any() //Make sure to have one instance of the DB

        operator fun invoke (context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDataBase(context).also {
                instance = it
            }
        }

        private fun buildDataBase(context: Context) =
                Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "DataBase.db")
                        .build()
    }

}