package vesel4ak.test.limehdtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.NonNull;


public class WebViewCompat extends WebView {

    MediaPlayer mediaPlayer;
    Listener listener;

    public WebViewCompat(@NonNull Context context) {
        super(context);
    }

    public WebViewCompat(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialization();
    }



    @SuppressLint("SetJavaScriptEnabled")
    public void initialization() {
        getSettings().setJavaScriptEnabled(true);
        setWebChromeClient(new WebChromeClient());
        loadUrl("file:///android_asset/lime_hd.html");
        playMusic();
    }

    public void playAndShow() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.music);
        }
        try {
            mediaPlayer.start();
            if (listener != null) {
                listener.onSuccessPlay();
            }
        } catch (Exception e) {
            if (listener != null) {
                listener.onFailurePlay();
            }
        }
        setVisibility(View.VISIBLE);
    }

    public void stopAndHide() {
        setVisibility(View.GONE);
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void playMusic() {
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.music);
        mediaPlayer.setLooping(true);
        try {
            mediaPlayer.start();
            if (listener != null) {
                listener.onSuccessPlay();
            }
        } catch (Exception e) {
            if (listener != null) {
                listener.onFailurePlay();
            }
        }
    }

    public void stopMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void seekToBegin() {
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(0);
        }
    }

    public void hide() {
        setVisibility(View.GONE);
    }

    public void show() {
        try {
            setVisibility(View.VISIBLE);
            if (listener!=null){
                listener.onSuccessShow();
            }
        }catch (Exception e){
            if (listener!=null){
                listener.onFailureShow();
            }
        }
    }

    public void destroyWebView() {
        clearHistory();
        clearCache(true);
        clearView();
        removeAllViews();
        destroy();
    }

    @Override
    public void destroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.destroy();
    }

    public void setMusicLoop(boolean loop) {
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(loop);
        }
    }


    public void loadHtml(final String html) {
        loadHtml(html, null);
    }


    public void loadHtml(final String html, final String baseUrl) {
        loadHtml(html, baseUrl, null);
    }


    public void loadHtml(final String html, final String baseUrl, final String historyUrl) {
        loadHtml(html, baseUrl, historyUrl, "utf-8");
    }


    public void loadHtml(final String html, final String baseUrl, final String historyUrl, final String encoding) {
        loadDataWithBaseURL(baseUrl, html, "text/html", encoding, historyUrl);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener {
        void onSuccessShow();

        void onFailureShow();

        void onSuccessPlay();

        void onFailurePlay();
    }
}
