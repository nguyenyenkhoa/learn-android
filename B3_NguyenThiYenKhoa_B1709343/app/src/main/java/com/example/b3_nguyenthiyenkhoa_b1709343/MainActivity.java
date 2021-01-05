package com.example.b3_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.view.SurfaceView;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        VeCoBan ve = new VeCoBan(this);
////        setContentView(ve);
//        View chuyenDong=new ChuyenDong(this);
////        setContentView(chuyenDong);

//        View tuongTac = new TuongTac(this);
//        setContentView(tuongTac);

        setContentView(R.layout.activity_main);
        final FrameLayout hienthi = (FrameLayout)findViewById(R.id.framelayout);
        Button bai1 = (Button)findViewById(R.id.class1);
        Button bai2 = (Button)findViewById(R.id.class2);
        Button bai3 = (Button)findViewById(R.id.class3);
        Button bai4 = (Button)findViewById(R.id.class4);
        Button thoat = (Button)findViewById(R.id.button1);
        Button trove = (Button)findViewById(R.id.button2);

        final VeCoBan ve= new VeCoBan(this);
        final ChuyenDong chuyenDong = new ChuyenDong(this);

        bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hienthi.addView(ve);
            }
        });

        bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hienthi.addView(chuyenDong);
            }
        });

        final TuongTac tuongTac = new TuongTac(this);
        bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hienthi.addView(tuongTac);
            }
        });

        final SurfaceView view = new GamePanel(this);
        bai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hienthi.addView(view);
            }
        });

        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}