package com.vicvestar.rentcollectionapp

import android.content.Intent
import android.graphics.Bitmap
import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.*
import android.widget.ProgressBar
import com.example.ipay_channels.iPay

class Checkout : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        webView = findViewById(R.id.webView)
        progressBar = findViewById(R.id.progressBar)

        val data = intent
        val c_email = data.getStringExtra("EMAIL").toString()
        val c_phone = data.getStringExtra("PHONE").toString()
        val c_amount = data.getStringExtra("AMOUNT").toString()
        Log.i("eml",c_email)
        Log.i("tel",c_phone)
        Log.i("amt",c_amount)

        renderWebView(c_email,c_phone,c_amount)

    }

    private fun renderWebView(c_email:String?, c_phone:String?, c_amount:String?){
        val live = "1"
        val oid = "12345"
        val inv = "67890"
        val vid = "ecml"
        val curr = "KES"
        val p1 = ""
        val p2 = ""
        val p3 = ""
        val p4 = ""
        val cbk = "https://www.example.com/callback"
        val cst = "1"
        val crl = "2"
        val hashKey = "6H8e6zmw4RUHfchy#qPknbqnVEs5rB@f"

        val response = iPay.getUrl(
            live,
            oid,
            inv,
            c_amount,
            c_phone,
            c_email,
            vid,
            curr,
            p1,
            p2,
            p3,
            p4,
            cbk,
            cst,
            crl,
            hashKey
        )

        Log.i("URL",response)

        // webView.loadUrl(response)

        //load url
        webView.apply {
            this.settings.loadsImagesAutomatically = true
            this.settings.javaScriptEnabled = true
            this.settings.useWideViewPort = true
            this.settings.loadWithOverviewMode = true
            this.settings.domStorageEnabled = true
            this.webViewClient = WebViewClient()
            webView.loadUrl(response)
        }

        webView.webViewClient = object : WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressBar.visibility = View.VISIBLE
                //swipeRefreshLayout.isRefreshing = false
            }

            override fun onPageCommitVisible(view: WebView?, url: String?) {
                super.onPageCommitVisible(view, url)
                progressBar.visibility = View.GONE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
                try {
                    webView.stopLoading()
                }catch (e : Exception){

                }
            }

        }
    }
}

