package com.example.buoi5_bai9_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class DisplayPictureList extends AppCompatActivity {
    Button back6;
    ListView lvpic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_picture_list);

        back6 = (Button) findViewById(R.id.btnTrove6);
        lvpic = (ListView) findViewById(R.id.lvpicture);

        ArrayList<String> listpic = new ArrayList<String>();
        ArrayAdapter<String> adapterpic = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listpic);

        lvpic.setAdapter(adapterpic);

        String[] projection = new String[]{MediaStore.Images.Media._ID, MediaStore.Images.Media.ARTIST, MediaStore.Images.Media.TITLE,
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.DURATION};

        Cursor cursor = getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                projection, null, null,
                "LOWER(" + MediaStore.Images.Media.TITLE + ") ASC");
        int count = 0;
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            String ds =
                    "count: " + count
                            + "\n_id: " + cursor.getString(0)
                            + "\n artist: " + cursor.getString(1)
                            + "\ntitle: " + cursor.getString(2)
                            + "\ndata: " + cursor.getString(3)
                            + "\ndisplay name: " + cursor.getString(4)
                            + "\n duration: " + cursor.getString(5)
                            + "\n--------------------------";

            listpic.add(ds);
            adapterpic.notifyDataSetChanged();

            Log.d("List Picture",
                    "\ncount: " + count + "\n_id: " + cursor.getString(0)
                            + "\n artist: " + cursor.getString(1) + "\ntitle: "
                            + cursor.getString(2) + "\ndata: "
                            + cursor.getString(3) + "\ndisplay name: "
                            + cursor.getString(4) + "\n duration: "
                            + cursor.getString(5)
                            + "\n--------------------------");
            cursor.moveToNext();
            count++;
        }
        cursor.close();

        back6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
