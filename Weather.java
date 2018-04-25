package eighteen.cmp.nan.itourbradford;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Weather extends AppCompatActivity {
    private WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);
        wv1 = (WebView) findViewById(R.id.wv011);
        wv1.setWebViewClient(new Mybrowser());
        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.loadUrl(" https://weather.com/en-GB/weather/today/l/53.80,-1.76");
    }
    private class Mybrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}