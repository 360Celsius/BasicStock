package com.a360celsius.basicstock.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.a360celsius.basicstock.R
import com.a360celsius.basicstock.ui.fragments.SearchTicketsFragment
import com.a360celsius.basicstock.ui.fragments.SettingsFragment
import com.a360celsius.basicstock.ui.fragments.SplashScreenFragment
import com.a360celsius.basicstock.ui.fragments.TicketPricesFragment
import kotlinx.android.synthetic.main.activity_live.*

class LiveActivity : BaseActivity() {

    private val ticketPricesFragment = TicketPricesFragment()
    private val settingsFragment = SettingsFragment()
    private val searchTicketsFragment = SearchTicketsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live)


        replaceFragment(searchTicketsFragment)
        bottomNav.selectedItemId =  R.id.menu_search

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_tickers -> {
                    replaceFragment(ticketPricesFragment)
                    true
                }
                R.id.menu_settings -> {
                    replaceFragment(settingsFragment)
                    true
                }
                R.id.menu_search -> {
                    replaceFragment(searchTicketsFragment)
                    true
                }

                else -> false
            }
        }

    }



    fun AppCompatActivity.replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_continer_activity_live,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}