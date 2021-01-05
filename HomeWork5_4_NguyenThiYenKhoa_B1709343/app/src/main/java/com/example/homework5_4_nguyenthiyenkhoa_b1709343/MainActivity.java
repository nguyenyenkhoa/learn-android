package com.example.homework5_4_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    MediaController mediaController;
    String SrcPath = "sdcard/Movies/myvideo.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.videoView);
//        String videoPath = "sdcard/mycatvideo.3gp/videoplayback.mp4";
//        //	Chỉ định	video	để play	từ thẻ nhớ
//        videoView.setVideoPath("");
////        videoView.setVideoURI(Uri.parse("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"));
//        Uri uri =  Uri.parse(videoPath);
//        videoView.setVideoURI(uri);
        videoView.setVideoPath(SrcPath);
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.start();
        mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}
