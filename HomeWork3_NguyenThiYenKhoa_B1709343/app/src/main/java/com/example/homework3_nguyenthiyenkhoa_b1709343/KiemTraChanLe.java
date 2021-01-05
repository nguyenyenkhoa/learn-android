package com.example.homework3_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KiemTraChanLe extends AppCompatActivity {
    String[] dayso = {"","","","",""};
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiem_tra_chan_le);
        final EditText so=(EditText)this.findViewById(R.id.so);
        final TextView kq=(TextView)this.findViewById(R.id.kq);
        final TextView ds=(TextView)this.findViewById(R.id.ds);
        Button back = (Button) this.findViewById(R.id.btnback);
        Button kt = (Button) this.findViewById(R.id.btnkt);
        kt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                for (int j=0;j<5;j++)
                    if(dayso[j].equals("")){
                        dayso[j]= so.getText().toString();
                        break;}
                    else
                    if(!dayso[j].equals("") && j==4)
                        for (int i=0;i<5;i++)
                            if (i==4)
                                dayso[i]=so.getText().toString();
                            else
                                dayso[i]=dayso[i+1];
                int skt = Integer.parseInt(so.getText().toString());
                if (skt%2==0)
                    kq.setText("Chẳn");
                else
                    kq.setText("Lẻ");
                ds.setText(" "+dayso[0]+" "+dayso[1]+" "+dayso[2]+" "+dayso[3]+" "+dayso[4]+" ");
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
