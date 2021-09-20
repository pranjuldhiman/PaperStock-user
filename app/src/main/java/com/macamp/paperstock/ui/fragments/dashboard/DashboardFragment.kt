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
import com.macamp.paperstock.databinding.DashboardFragmentBinding
import com.macamp.paperstock.utils.Constants.WEB_SOCKET_URL
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import timber.log.Timber
import java.net.URI
import javax.net.ssl.SSLSocketFactory


class DashboardFragment : Fragment() {
    private lateinit var webSocketClient: WebSocketClient
    private lateinit var viewModel: DashboardViewModel

    private lateinit var binding: DashboardFragmentBinding
    private var isShowing: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setUpViewPagerViewTabs()

        onClicks()
        initWebSocket()
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
        webSocketClient.close()
    }

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

    private fun createWebSocketClient(coinbaseUri: URI?) {
        webSocketClient = object : WebSocketClient(coinbaseUri) {

            override fun onOpen(handshakedata: ServerHandshake?) {
                Timber.e("onOpen")

                subscribe()
            }

            override fun onMessage(message: String?) {

                Timber.e("onMessage: $message")
//                setUpBtcPriceText(message)
            }

            override fun onClose(code: Int, reason: String?, remote: Boolean) {
                Timber.e("onClose: ")

//                unsubscribe()
            }

            override fun onError(ex: Exception?) {
                Timber.e("onError:${ex?.message}")

            }

        }
    }

    private fun subscribe() {
        webSocketClient.send(
            "{\"method\":\"addsymbol\",\"symbols\":[\"GOLD-I\",\"GOLDM-I\",\"COPPER-I\",\"ALUMINI-I\",\"CRUDEOIL-I\",\"LEAD-I\",\"NATURALGAS-I\",\"SILVER-I\"]}")
//  webSocketClient.send(
//            "{\"method\":\"addsymbol\",\"symbols\":[\"GOLD-I\"]}")

//        webSocketClient.send("{\"method\":\"addsymbol\",\"symbols\":[\"NIFTY-I\"]}")
//        webSocketClient.send("{\"method\":\"addsymbol\",\"symbols\":[\"USDINR-I\"]}")
    }


//    override fun onPause() {
//        super.onPause()
//        webSocketClient.close()
//    }


    private fun initWebSocket() {
        val coinbaseUri = URI(WEB_SOCKET_URL)

        createWebSocketClient(coinbaseUri)
        val socketFactory: SSLSocketFactory = SSLSocketFactory.getDefault() as SSLSocketFactory
        webSocketClient.setSocketFactory(socketFactory)
        webSocketClient.connect()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DashboardFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}