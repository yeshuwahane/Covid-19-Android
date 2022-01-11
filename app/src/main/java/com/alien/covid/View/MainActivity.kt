package com.alien.covid.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.alien.covid.R
import com.alien.covid.databinding.ActivityMainBinding
import com.alien.covid.utils.debug

class MainActivity : AppCompatActivity() {

    lateinit private var binding: ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        MainViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.progressbar.visibility = View.VISIBLE
        setUi()

    }


    fun setUi() {

        viewModel.getData()
        viewModel.responseLiveData.observe(this, Observer {
            binding.apply {
                debug("$it")
                progressbar.visibility = View.GONE
                binding.apply {
                    apiActiveNumbers.text = it.activeCases.toString()
                    apiTotalNumbers.text = it.totalCases.toString()
                    apiDeceasedNumbers.text = it.deaths.toString()
                    apiRecoveredNumbers.text = it.recovered.toString()
                    apiLastUpdated.text = it.lastUpdatedAtApify
                }
            }
        })

    }
}