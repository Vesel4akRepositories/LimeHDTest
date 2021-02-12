package vesel4ak.test.limehdtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.NonNull;

public class WebViewCompat extends WebView implements WebViewInterface {

    Player player;
    WebViewCallback webViewCallback;

    public WebViewCompat(@NonNull Context context) {
        super(context);
    }

    public WebViewCompat(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialization();
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void initialization() {
        player = new Player(getContext());
        getSettings().setJavaScriptEnabled(true);
        setWebChromeClient(new WebChromeClient());
        loadUrl("file:///android_asset/lime_hd.html");
        playMusic();
    }

    @Override
    public void playAndShow() {
        showWebView();
        try {
            player.playMusic();
            onSuccessPlay();
        } catch (Exception e) {
            onFailurePlay();
        }
    }

    @Override
    public void stopAndHide() {
        setVisibility(View.GONE);
        player.stopMusic();
    }

    @Override
    public void playMusic() {
        try {
            player.playMusic();
            onSuccessPlay();
        } catch (Exception e) {
            onFailurePlay();
        }
    }

    @Override
    public void stopMusic() {
        player.stopMusic();
    }

    @Override
    public void seekToBegin() {
        player.seekToBegin();
    }

    @Override
    public void hide() {
        setVisibility(View.GONE);
    }

    @Override
    public void show() {
        showWebView();
    }


    private void showWebView() {
        try {
            setVisibility(View.VISIBLE);
            if (webViewCallback != null) {
                webViewCallback.onSuccessShow();
            }
        } catch (Exception e) {
            if (webViewCallback != null) {
                webViewCallback.onFailureShow();
            }
        }
    }

    @Override
    public void destroyWebView() {
        clearHistory();
        clearCache(true);
        clearView();
        removeAllViews();
        destroy();
    }

    public WebViewInterface getWebViewInterface() {
        return this;
    }

    @Override
    public void destroy() {
        super.destroy();
        player.destroy();
    }

    @Override
    public void setMusicLoop(boolean loop) {
        if (player != null) {
            player.setLooping(loop);
        }
    }

    @Override
    public void reloadWebView() {
        reload();
    }

    public void setWebViewCallback(WebViewCallback listener) {
        webViewCallback = listener;
    }

    private void onFailurePlay() {
        if (webViewCallback != null) {
            webViewCallback.onFailurePlay();
        }
    }

    private void onSuccessPlay() {
        if (webViewCallback != null) {
            webViewCallback.onSuccessPlay();
        }
    }

}
