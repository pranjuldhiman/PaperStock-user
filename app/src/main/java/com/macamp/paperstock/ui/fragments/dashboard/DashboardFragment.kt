package com.macamp.paperstock.ui.fragments.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.macamp.paperstock.BuildConfig
import com.macamp.paperstock.R
import com.macamp.paperstock.utils.Constants.WEB_SOCKET_URL
import com.macamp.paperstock.utils.logger
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import timber.log.Timber
import java.lang.Exception
import java.net.URI
import javax.net.ssl.SSLSocketFactory


class DashboardFragment : Fragment() {
    private lateinit var webSocketClient: WebSocketClient
    private val logger = logger<DashboardFragment>()
    private lateinit var viewModel: DashboardViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
//        viewModel = DashboardViewModel()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
        initWebSocket()

    }



    override fun onPause() {
        super.onPause()
        webSocketClient.close()
    }


    private fun initWebSocket() {
        val coinbaseUri = URI(WEB_SOCKET_URL)

        createWebSocketClient(coinbaseUri)

        val socketFactory: SSLSocketFactory = SSLSocketFactory.getDefault() as SSLSocketFactory
        webSocketClient.setSocketFactory(socketFactory)
        webSocketClient.connect()
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
            "{\n" +
                    "    \"type\": \"subscribe\",\n" +
                    "    \"channels\": [{ \"name\": \"ticker\", \"product_ids\": [\"BTC-EUR\"] }]\n" +
                    "}"
        )
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dashboard_fragment, container, false)
    }

}