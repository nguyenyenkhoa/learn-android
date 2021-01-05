package com.example.homework3_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TinhTienBanHang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_tien_ban_hang);
        final EditText sl=(EditText)this.findViewById(R.id.soluong);
        final EditText gia=(EditText)this.findViewById(R.id.gia);
        final EditText thue=(EditText)this.findViewById(R.id.thue);
        final TextView tt=(TextView)this.findViewById(R.id.thanhtien);
        Button tinhtien = (Button) this.findViewById(R.id.btntti);
        Button tieptuc = (Button) this.findViewById(R.id.btntt);
        Button back = (Button) this.findViewById(R.id.btnback);
        tinhtien.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int s, g, t;
                float tien,thu;
                if (sl.getText().toString().equals("") || gia.getText().toString().equals("") || thue.getText().toString().equals(""))
                    Toast.makeText(TinhTienBanHang.this,"Vui lòng nhập đủ các giá trị", Toast.LENGTH_LONG).show();
                else{
                    s= Integer.parseInt(sl.getText().toString());
                    g= Integer.parseInt(gia.getText().toString());
                    t= Integer.parseInt(thue.getText().toString());
                    thu=(float)t/100;
                    tien= s*g;
                    tien+=thu*s*g;
                    tt.setText(String.format("%,.2f", tien));
                }
            }
        });
        tieptuc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sl.setText("");
                gia.setText("");
                thue.setText("");
                tt.setText("");
                sl.requestFocus();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}
