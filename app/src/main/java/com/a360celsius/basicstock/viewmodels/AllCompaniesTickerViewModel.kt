package com.a360celsius.basicstock.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.a360celsius.basicstock.data.db.entities.AllCompaniesTickerEntity
import com.a360celsius.basicstock.data.network.datamodels.AllCompaniesTickerDataModel
import com.a360celsius.basicstock.repositories.AllCompaniesTickerRepository
import com.a360celsius.basicstock.utils.Coroutines
import retrofit2.Response

class AllCompaniesTickerViewModel(
        private val allCompaniesTickerRepository: AllCompaniesTickerRepository
):ViewModel() {

    fun getAllCompaniesTicker() {
        Coroutines.backGround {

            try {
                Log.e("test", "Ticker YEAH")



                var allCompaniesTickerResponce: Response<List<AllCompaniesTickerDataModel>> = allCompaniesTickerRepository.getAllCompaniesTickerFromAPI()
                val allCompaniesTickerRepositoryArraySize: kotlin.Int? = allCompaniesTickerResponce.body()?.size?.minus(1)

                if(allCompaniesTickerResponce.isSuccessful){


                    for (i in 0..(allCompaniesTickerRepositoryArraySize ?: 0)) {
                        val allCompaniesTickerEntity: AllCompaniesTickerEntity = AllCompaniesTickerEntity(
                                i,
                                allCompaniesTickerResponce.body()?.get(i)?.symbol,
                                allCompaniesTickerResponce.body()?.get(i)?.name,
                                allCompaniesTickerResponce.body()?.get(i)?.date,
                                allCompaniesTickerResponce.body()?.get(i)?.isEnabled,
                                allCompaniesTickerResponce.body()?.get(i)?.type,
                                allCompaniesTickerResponce.body()?.get(i)?.iexId,
                        )
                        allCompaniesTickerRepository.saveAllCompaniesTickerToDB(allCompaniesTickerEntity)
                    }
                }

            }catch (e: Exception){
                Log.e("test", "Ticker FUCK")
            }
        }
    }


    fun getTicketsDataFromDB(): LiveData<List<AllCompaniesTickerEntity>>{
        return allCompaniesTickerRepository.getAllCompaniesTickerFromDB()
    }
}