package com.example.de2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnThongBao = (Button) findViewById(R.id.btnThongBao);
        Button btnTinhDiem = (Button) findViewById(R.id.btnTinhDiem);
        Button btnThoat = (Button) findViewById(R.id.btnThoat);
        CheckBox chkChucNang = (CheckBox) findViewById(R.id.chkChucNang);
        TextView txt1 = (TextView) findViewById(R.id.txt1);
        TextView txt2 = (TextView) findViewById(R.id.txt2);
        TextView txt3 = (TextView) findViewById(R.id.txt3);

        //Default : Off
        btnThongBao.setVisibility(View.INVISIBLE);
        btnTinhDiem.setVisibility(View.INVISIBLE);
        txt1.setVisibility(View.INVISIBLE);
        txt2.setVisibility(View.INVISIBLE);
        txt3.setVisibility(View.INVISIBLE);

        chkChucNang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                Button btnThongBao = (Button) findViewById(R.id.btnThongBao);
                Button btnTinhDiem = (Button) findViewById(R.id.btnTinhDiem);
                if (checked) {
                    btnThongBao.setVisibility(View.VISIBLE);
                    btnTinhDiem.setVisibility(View.VISIBLE);
                } else {
                    btnThongBao.setVisibility(View.INVISIBLE);
                    btnTinhDiem.setVisibility(View.INVISIBLE);
                }
            }
        });
        btnThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt1 = (TextView) findViewById(R.id.txt1);
                TextView txt2 = (TextView) findViewById(R.id.txt2);
                TextView txt3 = (TextView) findViewById(R.id.txt3);
                txt1.setVisibility(View.VISIBLE);
                txt2.setVisibility(View.VISIBLE);
                txt3.setVisibility(View.VISIBLE);

            }
        });
        btnTinhDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tinhdiem = new Intent(MainActivity.this,TinhDiem.class);
                startActivity(tinhdiem);
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }
}