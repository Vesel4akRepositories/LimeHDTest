package vesel4ak.test.limehdtest;

import android.content.Context;
import android.media.MediaPlayer;

public class Player{

    Context context;
    MediaPlayer mediaPlayer;

    public Player(Context context) {
        this.context = context;
        initPlayer();
    }

    public void playMusic() {
        initPlayer();
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    public void stopMusic() {
        initPlayer();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void seekToBegin() {
        initPlayer();
        mediaPlayer.seekTo(0);
    }

    public void setLooping(boolean loop){
        initPlayer();
        mediaPlayer.setLooping(loop);
    }

    private void initPlayer() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, R.raw.music);
        }
    }

    public void destroy(){
        if (mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}
