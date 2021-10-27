package com.macamp.paperstock.ui.fragments.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.macamp.paperstock.BuildConfig
import com.macamp.paperstock.R
import com.macamp.paperstock.adapter.ViewpagerAdapter
import com.macamp.paperstock.data.api.Status
import com.macamp.paperstock.databinding.DashboardFragmentBinding
import com.macamp.paperstock.utils.launchPeriodicAsync
import kotlinx.coroutines.*
import timber.log.Timber
import java.util.concurrent.TimeUnit

@InternalCoroutinesApi
class DashboardFragment : Fragment() {
    private val mainViewModel: DashboardViewModel by lazy {
        ViewModelProvider(this)[DashboardViewModel::class.java]
    }
//    private lateinit var viewModel: WebSocketViewModel

    private lateinit var binding: DashboardFragmentBinding
    private var isShowing: Boolean = false

    //    private var webSocketHashMap: HashMap<String, WebSocketData> = HashMap()
    private lateinit var fetchDatesTimer: Job
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        attachObservers()


        setUpViewPagerViewTabs()
        onClicks()

//        binding.imageVC.setOnClickListener { initWebSocket() }

    }


    private fun onClicks() {

        binding.showDetailsBtn.setOnClickListener {
            when {
                isShowing -> {
                    binding.marketPriceShow.visibility = View.GONE
                    isShowing = false
                    binding.showDetailsBtn.setImageResource(R.drawable.ic_arrow_down)
                }
                else -> {
                    binding.marketPriceShow.visibility = View.VISIBLE
                    isShowing = true
                    binding.showDetailsBtn.setImageResource(R.drawable.ic_close)

                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
    }


//    private fun observers() {
//        viewModel.getWebSocketData().observe(viewLifecycleOwner) {
//            it.let { stockData ->
//                webSocketHashMap[stockData.trade?.get(0).toString()] = stockData
//
//                webSocketHashMap.forEach { (name, data) ->
//                    Timber.e(data.trade?.get(0))
//                }
//            }
//            Timber.e("observers: ${webSocketHashMap.size}")
//        }
//
//        viewModel.historyData.observe(viewLifecycleOwner) {
//            it?.let { historySocketData ->
//                Timber.e("EMMITER ${historySocketData.symbollist[0][0]}")
//
//            }
//        }
//        viewModel.checkData.observe(viewLifecycleOwner) {
//            Timber.e(it)
//        }
//    }


    private fun setUpViewPagerViewTabs() {

        binding.viewPager.apply {
            adapter = ViewpagerAdapter(this@DashboardFragment)
        }
        TabLayoutMediator(binding.tabView, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "MCX Futures"
                }
                1 -> {
                    tab.text = "NSE Futures"
                }
            }

        }.attach()

    }


    private fun subscribe() {
        //  webSocketClient.send(
//            "{\"method\":\"addsymbol\",\"symbols\":[\"GOLD-I\"]}")

//        webSocketClient.send("{\"method\":\"addsymbol\",\"symbols\":[\"NIFTY-I\"]}")
//        webSocketClient.send("{\"method\":\"addsymbol\",\"symbols\":[\"USDINR-I\"]}")
    }


//    override fun onPause() {
//        super.onPause()
//        webSocketClient.close()
//    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DashboardFragmentBinding.inflate(layoutInflater, container, false)
//        viewModel.initWebSocket()
//        observers()
        return binding.root
    }

    private fun attachObservers() {

        fetchDatesTimer = startRepeatingJob(1000)

    }

    private fun startRepeatingJob(timeInterval: Long): Job {
        return MainScope().launch {
            while (NonCancellable.isActive) {
                // add your task here
                mainViewModel.getLiveStocks().observe(viewLifecycleOwner) {
                    it?.let {
                        when (it.status) {
                            Status.LOADING -> {
                            }
                            Status.ERROR -> {
                            }
                            Status.SUCCESS -> {
                                it.data?.let { data ->
                                    Timber.e("Stock active Data ${data.body()?.message}")
                                }

                            }

                        }
                    }
                }
                delay(timeInterval)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        fetchDatesTimer.cancel()

    }
    override fun onDestroy() {
        super.onDestroy()
        fetchDatesTimer.cancel()
    }

}