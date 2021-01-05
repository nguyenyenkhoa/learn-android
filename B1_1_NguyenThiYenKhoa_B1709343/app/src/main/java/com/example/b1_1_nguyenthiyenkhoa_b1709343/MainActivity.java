package com.example.b1_1_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btntest=(Button)findViewById(R.id.btntest);
        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayToast("You have chscked TEST Button");
            }
        });

        ImageButton btnImage=(ImageButton)findViewById(R.id.btnImage1);
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayToast("You have chscked IMAGEButton");
            }
        });

        Button btnexit=(Button)findViewById(R.id.btnexit);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayToast("You have checked EXIT Button");
                System.exit(0);
            }
        });

        ToggleButton btnToggle=(ToggleButton)findViewById(R.id.toggleButton);
        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit=(EditText)findViewById(R.id.edittext);
                String text=edit.getText().toString();
                TextView txt=(TextView)findViewById(R.id.textView2);

                if (((ToggleButton)v).isChecked())
                    txt.setText(text);
                else
                    txt.setText("");
            }
        });

        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton=(RadioButton)findViewById(R.id.radioButton);
                RadioButton radioButton2=(RadioButton)findViewById(R.id.radioButton2);
                ImageView imageView=(ImageView)findViewById(R.id.imageView);
                ImageView imageView2=(ImageView)findViewById(R.id.imageView2);

                if (radioButton.isChecked()){
                    imageView.setVisibility(ImageView.VISIBLE);
                    imageView2.setVisibility(ImageView.INVISIBLE);
                }
                if (radioButton2.isChecked()){
                    imageView2.setVisibility(ImageView.VISIBLE);
                    imageView.setVisibility(ImageView.INVISIBLE);
                }
            }
        });

        CheckBox chkautosave=(CheckBox)findViewById(R.id.checkBox);
        chkautosave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                    DisplayToast("“ChechBox is checked");
                else
                    DisplayToast("ChechBox is unchecked");
            }
        });

        CheckBox chkstar=(CheckBox)findViewById(R.id.checkBox1);
        chkstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                    DisplayToast("StarStyle CheckBox have checked");
                else
                    DisplayToast("StarSyle CheckBox have unchecked");
            }
        });
    }

    private void DisplayToast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }

}