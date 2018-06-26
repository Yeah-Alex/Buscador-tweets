package com.example.alejandro.buscadortweets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView miWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor(getResources().getColor(R.color.blanco));


        miWebView = findViewById(R.id.webview);
        miWebView.setWebChromeClient(new WebChromeClient());
        miWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });
        miWebView.loadUrl(getResources().getString(R.string.paginaHTML));


        WebSettings opciones = miWebView.getSettings();
        opciones.setDomStorageEnabled(true);
        opciones.setJavaScriptEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mi_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.acerca:
                Toast.makeText(this,
                        "Esta obra fue creado por Alejandro. Para esta aplicación se utilizó el Search API de Twitter.",
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.licencia:
                Toast.makeText(this,
                        "Esta obra está licenciada bajo la Licencia Creative Commons Atribución-NoComercial-SinDerivar 4.0 Internacional. Para ver una copia de esta licencia, visita http://creativecommons.org/licenses/by-nc-nd/4.0/.",
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.pagina:
                /*
                Intent mipagina = new Intent(Intent.ACTION_VIEW);
                mipagina.setData((Uri.parse("#")));
                startActivity(mipagina);
                */
                break;
        }
        return true;
    }


    @Override
    public void onBackPressed() {

        if (miWebView.canGoBack())
            miWebView.goBack();
        else
            finish();

    }

}
