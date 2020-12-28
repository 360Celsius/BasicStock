package com.a360celsius.basicstock.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a360celsius.basicstock.repositories.AllCompaniesTickerRepository
import com.a360celsius.basicstock.viewmodels.AllCompaniesTickerViewModel

class AllCompaniesTickerViewModelFactory(
        private val allCompaniesTickerRepository: AllCompaniesTickerRepository
): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AllCompaniesTickerViewModel(allCompaniesTickerRepository) as T
    }
}