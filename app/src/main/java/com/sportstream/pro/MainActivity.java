package com.sportstream.pro;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private WebView overlayWebView;
    private boolean isBlackout = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Postavljanje tvog Web Semafora (Overlay)
        overlayWebView = findViewById(R.id.overlay_webview);
        WebSettings webSettings = overlayWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        overlayWebView.setBackgroundColor(0); // Prozirno
        overlayWebView.setWebViewClient(new WebViewClient());
        
        // Ovdje ćeš kasnije upisati URL svog semafora
        overlayWebView.loadUrl("about:blank");

        // Gumb za Blackout (Hlađenje mobitela)
        Button btnBlackout = findViewById(R.id.btn_blackout);
        btnBlackout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isBlackout) {
                    overlayWebView.setVisibility(View.INVISIBLE);
                    isBlackout = true;
                } else {
                    overlayWebView.setVisibility(View.VISIBLE);
                    isBlackout = false;
                }
            }
        });
    }
}
