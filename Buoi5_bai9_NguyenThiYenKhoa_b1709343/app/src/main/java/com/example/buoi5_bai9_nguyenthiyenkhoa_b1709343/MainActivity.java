package com.example.buoi5_bai9_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button xemtc, xemls, xemds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xemtc = (Button)findViewById(R.id.btnxemtatca);
        xemls = (Button)findViewById(R.id.btnxemlichsu);
        xemds = (Button)findViewById(R.id.btnxemdanhsach);

//        xemtc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i1 = new Intent(MainActivity.this, DisplayAllContact.class);
//                startActivity(i1);
//            }
//        });
        xemtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DisplayAllContact.class);
                startActivity(i);
            }
        });
        xemls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MainActivity.this, DisplayAllCallLog.class);
                startActivity(i2);
            }
        });

        xemds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(MainActivity.this, MediaContent.class);
                startActivity(i3);
            }
        });
    }
}