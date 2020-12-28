package com.a360celsius.basicstock.data.network

import com.a360celsius.basicstock.data.network.datamodels.AllCompaniesTickerDataModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IexAPI {

    @GET("ref-data/symbols")
    suspend fun getAllCompaniesTicker(
    ):Response<List<AllCompaniesTickerDataModel>>


    companion object{
        operator fun invoke(): IexAPI {
            return Retrofit.Builder()
                    .baseUrl("https://api.iextrading.com/1.0/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(IexAPI::class.java)
        }
    }

}