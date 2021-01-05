package com.example.homework3_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DoiThapPhan_NhiPhan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_thap_phan__nhi_phan);
        final EditText so=(EditText)this.findViewById(R.id.so);
        final TextView tp=(TextView)this.findViewById(R.id.tp);
        final TextView np=(TextView)this.findViewById(R.id.np);
        Button tsn = (Button) this.findViewById(R.id.btntsn);
        Button nst = (Button) this.findViewById(R.id.btnnst);
        Button back = (Button) this.findViewById(R.id.btnback);
        tsn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean kts=true;
                for (int i=0; i<so.getText().toString().length();i++)
                    if(!Character.isDigit(so.getText().toString().charAt(i))){
                        Toast.makeText(DoiThapPhan_NhiPhan.this,"Chuỗi nhập vào không phải số nguyên", Toast.LENGTH_LONG).show();
                        kts=false;
                        break;
                    }
                if(kts){
                    int skt = Integer.parseInt(so.getText().toString());
                    tp.setText(so.getText().toString());
                    String snp = Integer.toBinaryString(skt);
                    np.setText(snp);}
            }
        });
        nst.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String skt = so.getText().toString();
                np.setText(skt);
                boolean kt=true;
                for (int i=0; i<skt.length();i++)
                    if(skt.charAt(i)!='0' && skt.charAt(i)!='1'){
                        Toast.makeText(DoiThapPhan_NhiPhan.this,"Chuỗi nhập vào không phải nhị phân", Toast.LENGTH_LONG).show();
                        kt=false;
                        tp.setText("");
                        np.setText("");
                        break;}
                if(kt){
                    int stp =  Integer.parseInt(skt, 2);
                    String stph = stp+"";
                    tp.setText(stph);}
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
