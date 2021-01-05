package com.example.homework3_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    Button btnexit ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnmenu=(Button)findViewById(R.id.btntmenu);
        btnmenu.setOnCreateContextMenuListener(this);

        //---CheckBox---
        CheckBox checkBox = (CheckBox) findViewById(R.id.chkAutosave);
        final AnalogClock an = (AnalogClock) findViewById(R.id.dongho);
        checkBox.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {

                if (((CheckBox)v).isChecked())
                    an.setVisibility(AnalogClock.INVISIBLE);
                else
                    an.setVisibility(AnalogClock.VISIBLE);
            }
        });

        btnexit = findViewById(R.id.btnthoat);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, view, menuInfo);
        CreateContextMenu(menu);
    };
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return contextmenuChoice(item);
    };
    public void CreateContextMenu(Menu menu) {
        MenuItem m1=menu.add(0, 0, 0, "KIỂM TRA CHẲN LẼ");
        {
            m1.setAlphabeticShortcut('e');
        }
        MenuItem m2=menu.add(0, 1, 1, "ĐỔI THẬP PHÂN-NHỊ PHÂN");
        {
            m2.setAlphabeticShortcut('f');
        }
        MenuItem m3=menu.add(0, 2, 2, "TÍNH TIỀN BÁN HÀNG");
        {
            m3.setAlphabeticShortcut('g');
        }
    };
    public boolean contextmenuChoice(MenuItem item){
        switch(item.getItemId()){
            case 0:
                Intent i0 = new Intent(MainActivity.this, KiemTraChanLe.class);
                startActivity(i0);
                return true;
            case 1:
                Intent i1 = new Intent(MainActivity.this, DoiThapPhan_NhiPhan.class);
                startActivity(i1);
                return true;
            case 2:
                Intent i2 = new Intent(MainActivity.this, TinhTienBanHang.class);
                startActivity(i2);
                return true;
        }
        return false;
    };
}
