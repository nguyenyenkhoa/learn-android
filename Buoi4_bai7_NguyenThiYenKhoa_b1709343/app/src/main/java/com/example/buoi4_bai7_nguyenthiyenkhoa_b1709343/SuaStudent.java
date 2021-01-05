package com.example.buoi4_bai7_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SuaStudent extends AppCompatActivity {
    DBAdapter db = new DBAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_student);
        final EditText sott=(EditText)this.findViewById(R.id.stt);//Thêm
        final EditText masosv=(EditText)this.findViewById(R.id.mssv1);//Thêm
        final EditText ten=(EditText)this.findViewById(R.id.hoten);
        final EditText email=(EditText)this.findViewById(R.id.email);
        final EditText phone_number = (EditText)this.findViewById(R.id.phone);

        final TextView ct=(TextView)this.findViewById(R.id.hienthisua);
        Button suacontact=(Button)this.findViewById(R.id.btnsua);
        Button trove=(Button)this.findViewById(R.id.btntrove);

        suacontact.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                db.open();
                String masosinhvien=masosv.getText().toString();
                String tensv=ten.getText().toString();
                String e_mail=email.getText().toString();
                String sodienthoai = phone_number.getText().toString();

                int chiso=Integer.parseInt(sott.getText().toString());
                //---update contact---
                if (db.updateStudent(chiso,masosinhvien,tensv,e_mail, sodienthoai)){
                    ct.setText("thành công.");}
                else {
                    ct.setText("không thành công, đây là giá trị cũ, vui lòng thực hiện lại lần nữa");
                }
//                Cursor c = db.getAllStudent();
//                c.moveToPosition(chiso-1);
//                String tx="id: " + c.getString(0) + "\n" +
//                        "MSSV: " + c.getString(1) + "\n" +
//                        "Name: " + c.getString(2) + "\n" +
//                        "Email: " + c.getString(3);
//                ct.setText(tx);
                Cursor cc = db.getStudent(chiso);
                if (cc.moveToFirst()){
                    String tx = "id: " + cc.getString(0) + "\n" +
                            "MSSV: " + cc.getString(1) + "\n" +
                            "Name: " + cc.getString(2) + "\n" +
                            "Email: " + cc.getString(3) + "\n" +
                            "Phone: " + cc.getString(4);
                    ct.setText(tx);
                }
                db.close();
            }
        });
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(SuaStudent.this,MainActivity.class);
                startActivity(intent3);
            }
        });

    }
}