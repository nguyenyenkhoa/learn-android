package com.example.homework5_2_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    private int position = 0;
    private MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.videoView);
// Tạo bộ điều khiển
        if (mediaController == null) { mediaController = new
                MediaController(MainActivity.this);
// Neo vị trí của MediaController với VideoView.
            mediaController.setAnchorView(videoView);
// Đặt bộ điều khiển cho VideoView.
            videoView.setMediaController(mediaController); }
        try {
// ID của file video.
            int id = this.getRawResIdByName("myvideo");
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() +
                    "/" + id));
        } catch (Exception e) { Log.e("Error", e.getMessage()); e.printStackTrace(); }
        videoView.requestFocus();
// Sự kiện khi file video sẵn sàng để chơi.
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.seekTo(position); if (position == 0) { videoView.start();
                }
// Khi màn hình Video thay đổi kích thước
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
// Neo lại vị trí của bộ điều khiển của nó vào VideoView.
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });
    }
// Tìm ID ứng với tên của file nguồn (Trong thư mục raw).
public int getRawResIdByName(String resName) {
    String pkgName = this.getPackageName();
// Trả về 0 nếu không tìm thấy.
    int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
    Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " +
            resID); return resID; }
    // Khi bạn xoay điện thoại, phương thức này sẽ được gọi // nó lưu trữ lại ví trí file videođang chơi.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
// Lưu lại vị trí file video đang chơi.
        savedInstanceState.putInt("CurrentPosition", videoView.getCurrentPosition());
        videoView.pause(); }
    // Sau khi điện thoại xoay chiều xong. Phương thức này được gọi,
// bạn cần tái tạo lại ví trí file nhạc đang chơi.
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
// Lấy lại ví trí video đã chơi.
        position = savedInstanceState.getInt("CurrentPosition"); videoView.seekTo(position);
    }
}
