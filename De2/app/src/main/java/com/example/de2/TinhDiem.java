package com.example.de2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class TinhDiem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_diem);

        Button btnDiemTongHop = (Button)findViewById(R.id.btnDiemTongHop);
        Button btnTiepTuc = (Button)findViewById(R.id.btnTiepTuc);
        Button btnTroVe = (Button)findViewById(R.id.btnTroVe);

        btnDiemTongHop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtTH = (EditText) findViewById(R.id.txtTH);
                EditText txtTN = (EditText) findViewById(R.id.txtTN);
                EditText txtTTH = (EditText) findViewById(R.id.txtTTH);
                EditText txtkqua = (EditText) findViewById(R.id.txtkqua);

                float thucHanh = Float.parseFloat(txtTH.getText().toString());
                float tracNghiem = Float.parseFloat(txtTN.getText().toString());
                float thiThucHanh = Float.parseFloat(txtTTH.getText().toString());

                double diemTB = ((thucHanh*0.3)+(tracNghiem*0.4)+(thiThucHanh+0.3));
                String s = Double.toString(diemTB);
                txtkqua.setText(s);

            }
        });
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtTH = (EditText) findViewById(R.id.txtTH);
                EditText txtTN = (EditText) findViewById(R.id.txtTN);
                EditText txtTTH = (EditText) findViewById(R.id.txtTTH);
                EditText txtkqua = (EditText) findViewById(R.id.txtkqua);

                txtTH.setText("");
                txtTN.setText("");
                txtTTH.setText("");
                txtkqua.setText("");
            }
        });
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(TinhDiem.this,MainActivity.class);
                startActivity(main);
            }
        });
    }
}