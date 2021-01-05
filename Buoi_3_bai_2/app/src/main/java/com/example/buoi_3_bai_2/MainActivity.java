package com.example.buoi_3_bai_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editValue = (EditText) findViewById(R.id.value_edit);
        final Button sendButton = (Button) findViewById(R.id.send_button);

        sendButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String valueString = editValue.getText().toString();
                long value;
                if (!valueString.equals("")) {
                    value = Long.parseLong(valueString);
                }
                else {
                    value = 0;
                }
                //Tạo 1 đối tượng Bundle để gửi đi cùng Intent
                Bundle sendBundle = new Bundle();
                sendBundle.putLong("value", value);
                //Tạo Intent để khởi chạy Activity2 và gắn đối tượng sendBundble vào Intent
                Intent i = new Intent(MainActivity.this, Activity2.class);
                i.putExtras(sendBundle); // Dùng hàm putExtras
                startActivity(i);
                //Giải phóng Activity1 khỏi Activity Stack vì ta sẽ không quay lại nó nữa
                finish();
            }
        });
            }
    }