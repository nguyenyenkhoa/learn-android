package com.example.bai10_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StaticResources extends AppCompatActivity {
    TextView hd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_resources);
          hd = (TextView)findViewById(R.id.txthd);
            InputStream is = this.getResources().openRawResource(R.raw.huongd);
             InputStreamReader ir=new InputStreamReader(is);
             BufferedReader br = new BufferedReader(ir);
        String str = null;
        try {
            while ((str = br.readLine()) != null) {
                hd.setText(str);
            }
            is.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}