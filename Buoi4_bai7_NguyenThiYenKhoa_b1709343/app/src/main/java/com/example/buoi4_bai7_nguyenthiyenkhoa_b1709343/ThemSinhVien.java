package com.example.buoi4_bai7_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThemSinhVien extends AppCompatActivity {
    DBAdapter db = new DBAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sinh_vien);

        final EditText masosv = (EditText)this.findViewById(R.id.mssv);
        final EditText ten = (EditText)this.findViewById(R.id.hoten);
        final EditText email = (EditText)this.findViewById(R.id.email);
        final EditText phone = (EditText)this.findViewById(R.id.phone);
        final TextView ct = (TextView)this.findViewById(R.id.studentduocthem);
        Button themcontact = (Button)this.findViewById(R.id.btnthem);
        Button trove = (Button)this.findViewById(R.id.btntrove);

        themcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.open();
                String masosinhvien = masosv.getText().toString();
                String hoten = ten.getText().toString();
                String e_mail = email.getText().toString();
                String sodienthoai = phone.getText().toString();
                long id = db.insertStudent(hoten, masosinhvien, e_mail,sodienthoai);

                Cursor c = db.getAllStudent();
                c.moveToLast();

                String tx = "id: " + c.getString(0) + "\n" +
                        "MSSV: " + c.getString(1) + "\n" +
                        "Name: " + c.getString(2) + "\n" +
                        "Email: " + c.getString(3) + "\n" +
                        "Phone: " + c.getString(4);
                ct.setText(tx);

                db.close();
            }
        });

        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemSinhVien.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}