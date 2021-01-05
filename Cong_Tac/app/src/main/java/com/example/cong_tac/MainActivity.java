package com.example.cong_tac;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    boolean ct1_on ;
    boolean ct2_on ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        2. Lập trình tương tác 1
//        cong tac 1

        RadioGroup radioGroup1=(RadioGroup) findViewById(R.id.radiocong1);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton ctrb1=(RadioButton)findViewById(R.id.cong1bat);
                RadioButton ctrb2=(RadioButton)findViewById(R.id.cong1tat);
                TextView txt1=(TextView)findViewById(R.id.congtac1);
                if (ctrb1.isChecked()){
                    txt1.setText("Bật");
                    ct1_on=true;
                }
                if (ctrb2.isChecked()){
                    txt1.setText("Tắt");
                    ct1_on=false;
                }
            }
        });
//        cong tac 2
        RadioGroup radioGroup2=(RadioGroup) findViewById(R.id.radiocong2);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton ct2rb1=(RadioButton)findViewById(R.id.cong2bat);
                RadioButton ct2rb2=(RadioButton)findViewById(R.id.cong2tat);
                TextView txt1=(TextView)findViewById(R.id.congtac2);
                if (ct2rb1.isChecked()){
                    txt1.setText("Bật");
                    ct2_on=true;

                }
                if (ct2rb2.isChecked()){
                    txt1.setText("Tắt");
                    ct2_on=false;

                }
            }
        });
        // btn kiem tra
        Button nut3=(Button)this.findViewById(R.id.btnkt);
        nut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent res = new Intent(MainActivity.this,Congtac_res.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("switch1", ct1_on);
                bundle.putBoolean("switch2", ct2_on);
                res.putExtras(bundle);
                startActivity(res);
            }
        });

//        5 - btn thoat
        Button nut6=(Button)this.findViewById(R.id.btnthoat);
        nut6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });
    }
}