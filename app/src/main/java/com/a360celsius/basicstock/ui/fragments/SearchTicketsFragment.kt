package com.a360celsius.basicstock.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.a360celsius.basicstock.R
import com.a360celsius.basicstock.databinding.SearchTicketsFragmentBinding
import com.a360celsius.basicstock.viewmodels.AllCompaniesTickerViewModel
import com.a360celsius.basicstock.viewmodels.factories.AllCompaniesTickerViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext

class SearchTicketsFragment : Fragment(), KodeinAware {

    private lateinit var binding: SearchTicketsFragmentBinding

    final override val kodeinContext = kcontext<Fragment>(this)
    final override val kodein: Kodein by kodein()

    private val factoryTickers : AllCompaniesTickerViewModelFactory by instance()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.search_tickets_fragment, container, false)
        binding.setLifecycleOwner(this)


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


      //  val viewModelTickers = ViewModelProviders.of(this, factoryTickers).get(AllCompaniesTickerViewModel::class.java)

        val layoutManager = LinearLayoutManager(context)

//        viewModelTickers.getTicketsDataFromDB().observe(viewLifecycleOwner, Observer { cryptoUsdData ->
//            if (cryptoUsdData != null) {
//                //Log.e("test","symbol " + (cryptoUsdData.name ?: "N/A"))
//
//                all_tickers_recycler_view.layoutManager = layoutManager
//                all_tickers_recycler_view.hasFixedSize()
//                all_tickers_recycler_view.adapter = AllTickersFragmentAdapter(cryptoUsdData)
//                //all_tickers_recycler_view.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
//
//
//            }
//        })


      //  binding.viewmodel = viewModelTickers
    }
}