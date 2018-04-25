package eighteen.cmp.nan.itourbradford;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Travel extends AppCompatActivity {
    private WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        wv1 = (WebView) findViewById(R.id.wv011);
        wv1.setWebViewClient(new Mybrowser());
        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.loadUrl("https://www.firstgroup.com/leeds/plan-journey/timetables/?operator=16&service=bradford&page=1&redirect=no");
    }

    private class Mybrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
