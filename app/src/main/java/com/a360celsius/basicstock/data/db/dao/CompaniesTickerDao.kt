package com.a360celsius.basicstock.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.a360celsius.basicstock.data.db.entities.AllCompaniesTickerEntity

@Dao
interface CompaniesTickerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCompaniesTickerToDB(allCompaniesTickerEntity: AllCompaniesTickerEntity)

    @Query("SELECT * FROM all_companies_ticker")
    fun getAllCompaniesTickerFromDB(): LiveData<List<AllCompaniesTickerEntity>>



}