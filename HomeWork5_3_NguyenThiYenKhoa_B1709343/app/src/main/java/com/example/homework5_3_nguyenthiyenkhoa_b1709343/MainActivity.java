package com.example.homework5_3_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    String videoUrl = "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4";
    ProgressDialog pd;
    private int position = 0;
    private MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView)findViewById(R.id.videoView);
        mediaController = new MediaController(MainActivity.this);
        // Neo vị trí của MediaController với VideoView.
        mediaController.setAnchorView(videoView);
        // Đặt bộ điều khiển cho VideoView.
        videoView.setMediaController(mediaController);
        pd = new ProgressDialog(MainActivity.this);
        pd.show();
        Uri uri=Uri.parse(videoUrl);
        videoView.setVideoURI(uri);
//        videoUrl = "\"http://www.youtubemaza.com/files/data/366/Tom%20And%20Jerry%20055%20\n" +"Casano va%20Cat%20(1951).mp4";
        videoView.start();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                pd.dismiss();
                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();
                }
                // Khi màn hình Video thay đổi kích thước
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        // Neo lại vị trí của bộ điều khiển của nó vào VideoView.
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });
    }
    // Khi bạn xoay điện thoại, phương thức này sẽ được gọi // nó lưu trữ lại ví trí file video đang chơi.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
// Lưu lại vị trí file video đang chơi.
        savedInstanceState.putInt("CurrentPosition", videoView.getCurrentPosition());
        videoView.pause();
    }
    // Sau khi điện thoại xoay chiều xong. Phương thức này được gọi,
// bạn cần tái tạo lại ví trí file nhạc đang chơi.
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
// Lấy lại ví trí video đã chơi.
        position = savedInstanceState.getInt("CurrentPosition"); videoView.seekTo(position);
    }
}
