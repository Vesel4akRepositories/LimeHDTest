package vesel4ak.test.limehdtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebViewCompat webView;
    WebViewInterface webViewInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        webView.setWebViewCallback(new WebViewCallback() {
            @Override
            public void onSuccessPlay() {

            }

            @Override
            public void onFailurePlay() {

            }

            @Override
            public void onSuccessShow() {
                Log.d("TAG", "onSuccessShow");
            }

            @Override
            public void onFailureShow() {

            }
        });
        webViewInterface = webView.getWebViewInterface();

    }

    public void stopMusic(View view) {
        webViewInterface.stopMusic();
    }

    public void show(View view) {
        webViewInterface.show();
    }

    public void destroyWebView(View view) {
        webViewInterface.destroyWebView();
    }
}