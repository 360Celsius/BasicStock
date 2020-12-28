package com.a360celsius.basicstock.data.network.datamodels

data class AllCompaniesTickerDataModel (
        var symbol: String?,
        var name: String?,
        var date: String?,
        var isEnabled: Boolean?,
        var type: String?,
        var iexId: String?
)