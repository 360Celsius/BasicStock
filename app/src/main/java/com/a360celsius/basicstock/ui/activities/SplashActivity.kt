package com.a360celsius.basicstock.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.a360celsius.basicstock.R
import com.a360celsius.basicstock.ui.fragments.SplashScreenFragment
import com.a360celsius.basicstock.viewmodels.MainActivityViewModel

class SplashActivity : BaseActivity() {

    private val splashFragment = SplashScreenFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        replaceFragment(splashFragment)

        val mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.isSplashFinishedLoadingTickersData.observe(this, Observer{
            it?.let {
                if(it){
                    val intent = Intent(this, LiveActivity::class.java)
                    // start your next activity
                   startActivity(intent)
                    finish()
                }
            }
        })
    }


    fun AppCompatActivity.replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_continer_splash_activity,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}