package com.a360celsius.basicstock.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import com.a360celsius.basicstock.data.db.DataBase
import com.a360celsius.basicstock.data.db.entities.AllCompaniesTickerEntity
import com.a360celsius.basicstock.data.network.IexAPI
import com.a360celsius.basicstock.data.network.datamodels.AllCompaniesTickerDataModel
import retrofit2.Response

class AllCompaniesTickerRepository(
        private val iexAPI: IexAPI,
        private val db: DataBase
) {

    val apiKey: String = "8bafd55d97ff72f5c6f9943cc9ce5656"

    suspend fun getAllCompaniesTickerFromAPI(): Response<List<AllCompaniesTickerDataModel>>{
        val allCompaniesTickerFromAPI: Response<List<AllCompaniesTickerDataModel>> = iexAPI.getAllCompaniesTicker()
        return allCompaniesTickerFromAPI
    }

    suspend fun saveAllCompaniesTickerToDB(allCompaniesTickerEntity: AllCompaniesTickerEntity){
        db.getAllCompaniesTickerDao().insertAllCompaniesTickerToDB(allCompaniesTickerEntity)
    }

    fun getAllCompaniesTickerFromDB(): LiveData<List<AllCompaniesTickerEntity>>{
        return db.getAllCompaniesTickerDao().getAllCompaniesTickerFromDB()
    }

}