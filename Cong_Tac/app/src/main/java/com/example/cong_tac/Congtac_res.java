package com.example.cong_tac;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class Congtac_res extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congtac_res);
        ToggleButton btnres1 = findViewById(R.id.ct1_trangthai);
        ToggleButton btnres2 = findViewById(R.id.ct2_trangthai);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            boolean State1 = bundle.getBoolean("switch1");
            boolean State2 = bundle.getBoolean("switch2");
            if(State1 == true ){
                btnres1.setText("Bật");
            } else {
                btnres1.setText("Tắt");
            }
            if(State2 == true ){
                btnres2.setText("Bật");
            } else {
                btnres2.setText("Tắt");
            }
        }
        Button backButton = findViewById(R.id.btn_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}