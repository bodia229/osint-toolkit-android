package com.osint.toolkit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.osint.toolkit.databinding.ActivityWebviewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var b: ActivityWebviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(b.root)

        val url = intent.getStringExtra("url") ?: "https://google.com"
        val title = intent.getStringExtra("title") ?: ""

        b.tvTitle.text = title

        b.webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            loadWithOverviewMode = true
            useWideViewPort = true
            setSupportZoom(true)
            builtInZoomControls = true
            displayZoomControls = false
        }

        b.webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                b.progressBar.visibility = if (newProgress < 100) View.VISIBLE else View.GONE
                b.progressBar.progress = newProgress
            }
        }

        b.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                return false
            }
        }

        b.webView.loadUrl(url)

        b.btnBack.setOnClickListener { finish() }
        b.btnNavBack.setOnClickListener { if (b.webView.canGoBack()) b.webView.goBack() }
        b.btnNavForward.setOnClickListener { if (b.webView.canGoForward()) b.webView.goForward() }
        b.btnRefresh.setOnClickListener { b.webView.reload() }
        b.btnBrowser.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(b.webView.url ?: url)))
        }
    }

    override fun onBackPressed() {
        if (b.webView.canGoBack()) b.webView.goBack()
        else super.onBackPressed()
    }
}
