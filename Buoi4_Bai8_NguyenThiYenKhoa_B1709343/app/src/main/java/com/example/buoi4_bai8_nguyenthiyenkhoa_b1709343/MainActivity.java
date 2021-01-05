package com.example.buoi4_bai8_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.os.Bundle;
import android.net.Uri;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAddName(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();
        values.put(B1709343Provider.NAME,((EditText)findViewById(R.id.editText2)).getText().toString());
        values.put(B1709343Provider.BUOI,((EditText)findViewById(R.id.editText3)).getText().toString());
        Uri uri = getContentResolver().insert(B1709343Provider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),uri.toString(), Toast.LENGTH_LONG).show();
    }
    public void onClickRetrieveStudents(View view) {
        Uri students = B1709343Provider.CONTENT_URI;
        String[] projection = {B1709343Provider._ID, B1709343Provider.NAME, B1709343Provider.BUOI};
        androidx.loader.content.CursorLoader loader = new CursorLoader(this,students, projection,null, null,null);
        Cursor c = loader.loadInBackground();
        final TextView ct = (TextView)findViewById(R.id.hienthi);
        c.moveToFirst();
        String s = "";
        while (!c.isAfterLast()){
            for (int i=0; i<c.getColumnCount();i++){
                s+= c.getString(i)+"-";
            }
            s+="\n";
            c.moveToNext();
        }
        ct.setText(s);
//        Toast.makeText(this,s,Toast.LENGTH_LONG).show();


        c.close();
    }
}