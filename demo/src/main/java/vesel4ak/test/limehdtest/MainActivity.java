package vesel4ak.test.limehdtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        webView = findViewById(R.id.webView);
//        webView.setListener(new WebViewCompat.Listener() {
//            @Override
//            public void onSuccessShow() {
//                Log.d("TAG", "onSuccessShow");
//            }
//
//            @Override
//            public void onFailureShow() {
//                Log.d("TAG", "onFailureShow");
//            }
//
//            @Override
//            public void onSuccessPlay() {
//                Log.d("TAG", "onSuccessPlay");
//            }
//
//            @Override
//            public void onFailurePlay() {
//                Log.d("TAG", "onFailurePlay");
//            }
//        });
    }

    public void stopMusic(View view) {
     //   webView.stopAndHide();
    }

    public void show(View view) {
//        webView.playAndShow();
//        webView.reload();
    }

    public void destroyWebView(View view) {
     //  webView.destroyWebView();
    }
}