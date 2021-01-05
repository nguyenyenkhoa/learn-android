package com.example.buoi4_bai7_nguyenthiyenkhoa_b1709343;

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
    DBAdapter db = new DBAdapter(this);
    ListView lv;
    ArrayList<String> arrayList = null;
    ArrayAdapter<String> adapter = null;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button themsv = (Button) this.findViewById(R.id.btnthemsv);
        Button xemtatcasv = (Button) this.findViewById(R.id.btnxemtatca);
        Button xemmotsv = (Button) this.findViewById(R.id.btnxemmotsv);
        Button suamotsv = (Button) this.findViewById(R.id.btncapnhatsv);
        Button xoamotsv = (Button) this.findViewById(R.id.btnxoamotsv);
        Button trove = (Button) this.findViewById(R.id.btntrove);

        //Them mot sinh vien

        themsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, ThemSinhVien.class);
                startActivity(it);
            }
        });

        lv = (ListView) findViewById(R.id.lvperson);
        //Tao array objects
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        lv.setAdapter(adapter);

        xemtatcasv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.open();
                Cursor c = db.getAllStudent();
                if (c.moveToFirst()){
                    do{
                        String msg = "id: " + c.getString(0) + "\n" +
                                "MSSV: " + c.getString(1) + "\n" +
                                "Name: " + c.getString(2) + "\n" +
                                "Email: " + c.getString(3);
//                                "Phone: " + c.getString(4);

                        arrayList.add(msg);
                        adapter.notifyDataSetChanged();
                        c.moveToNext();
                    }

                    while (c.isAfterLast()==false);
                }
                db.close();
            }
        });

        xemmotsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Xem1Student.class);
                startActivity(it);
            }
        });

        suamotsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, SuaStudent.class);
                startActivity(it);
            }
        });

        xoamotsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, XoaStudent.class);
                startActivity(it);
            }
        });
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                Intent it = new Intent(MainActivity.this, MainActivity.class);
                startActivity(it);
            }
        });

    }
}