package com.a360celsius.basicstock.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "all_companies_ticker")
data class AllCompaniesTickerEntity (
        @PrimaryKey
        var id: Int,
        @ColumnInfo(name = "symbol") var symbol: String?,
        @ColumnInfo(name = "name") var name: String?,
        @ColumnInfo(name = "date") var date: String?,
        @ColumnInfo(name = "isEnabled") var isEnabled: Boolean?,
        @ColumnInfo(name = "type") var type: String?,
        @ColumnInfo(name = "iexId") var iexId: String?,
)