package com.a360celsius.basicstock

import android.app.Application
import com.a360celsius.basicstock.data.db.DataBase
import com.a360celsius.basicstock.data.network.IexAPI
import com.a360celsius.basicstock.repositories.AllCompaniesTickerRepository
import com.a360celsius.basicstock.viewmodels.factories.AllCompaniesTickerViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidCoreModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class BasicStockApp : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidCoreModule(this@BasicStockApp))

        bind() from singleton { IexAPI() }

        bind() from singleton { DataBase(instance()) }

        bind() from singleton { AllCompaniesTickerRepository(instance(),instance()) }

        bind() from provider { AllCompaniesTickerViewModelFactory(instance()) }


    }
}