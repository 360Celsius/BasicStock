package com.a360celsius.basicstock.ui.viewadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.a360celsius.basicstock.R
import com.a360celsius.basicstock.data.db.entities.AllCompaniesTickerEntity
import com.a360celsius.basicstock.databinding.TickerListItemBinding


class AllTickersFragmentAdapter(cryptoUsdData: List<AllCompaniesTickerEntity>) : RecyclerView.Adapter<AllTickersFragmentAdapter.ViewHolder>() {

    private var items: List<AllCompaniesTickerEntity> = cryptoUsdData

    private val loading = 0
    private val item = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ItemViewHolder(parent)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ItemViewHolder && items.size > position) {
            holder.bind(items[position].name.toString(), items[position].date.toString() , items[position].iexId.toString())
        }
    }

    fun update(items: List<AllCompaniesTickerEntity>) {
        this.items = items
        notifyDataSetChanged()
    }

    companion object {
        @JvmStatic
        @BindingAdapter("items")
        fun RecyclerView.bindItems(items: List<AllCompaniesTickerEntity>) {
            val adapter = adapter as AllTickersFragmentAdapter
            adapter.update(items)
        }
    }

    override fun getItemViewType(position: Int) =
        item

    abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class ItemViewHolder(
        private val parent: ViewGroup,
        private val binding: TickerListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.ticker_list_item,
            parent,
            false
        )
    ) : ViewHolder(binding.root) {

        fun bind(symbol: String,exchange: String, price: String ) {
            binding.symbol.text = symbol
            binding.exchange.text = exchange
            binding.price.text = price
        }
    }
}