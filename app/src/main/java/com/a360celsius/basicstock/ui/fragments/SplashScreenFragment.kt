package com.a360celsius.basicstock.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.a360celsius.basicstock.R
import com.a360celsius.basicstock.databinding.SplashScreenFragmentBinding
import com.a360celsius.basicstock.viewmodels.AllCompaniesTickerViewModel
import com.a360celsius.basicstock.viewmodels.MainActivityViewModel
import com.a360celsius.basicstock.viewmodels.factories.AllCompaniesTickerViewModelFactory
import com.airbnb.lottie.RenderMode
import kotlinx.android.synthetic.main.splash_screen_fragment.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext

class SplashScreenFragment : Fragment(), KodeinAware {

    private lateinit var binding: SplashScreenFragmentBinding

    final override val kodeinContext = kcontext<Fragment>(this)
    final override val kodein: Kodein by kodein()

    private val allCompaniesTickerViewModelFactory: AllCompaniesTickerViewModelFactory by instance()


    private var mainActivityViewModel: MainActivityViewModel? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.splash_screen_fragment,container,false)
        binding.setLifecycleOwner(this)

        activity?.let {
            mainActivityViewModel = ViewModelProviders.of(it).get(MainActivityViewModel::class.java)
        }

        val allCompaniesTickerViewModel = ViewModelProviders.of(this,allCompaniesTickerViewModelFactory).get(AllCompaniesTickerViewModel::class.java)

        allCompaniesTickerViewModel.getAllCompaniesTicker()

        allCompaniesTickerViewModel.getTicketsDataFromDB().observe(viewLifecycleOwner, Observer { ticketsData ->
            if(ticketsData!=null && ticketsData.isNotEmpty() && ticketsData.size == 9363) { // size = 9363 tiger only when ALL tickers symbols in db


                mainActivityViewModel?.isSplashFinishedLoadingTickersData?.value = true

            }

        })

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(splash_animation!=null) {
            splash_animation.playAnimation()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if(splash_animation!=null) {
            splash_animation.cancelAnimation()
        }
    }

}