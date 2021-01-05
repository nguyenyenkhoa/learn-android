package com.example.bai15_buoi6_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
public class MainActivity extends AppCompatActivity{
    public InputStream OpenHttpConnection(String urlString) throws IOException{
        InputStream in = null;
        int response = -1;
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        if (!(conn instanceof HttpURLConnection))
            throw new IOException("Not an HTTP connection");
        try{
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            response = httpConn.getResponseCode();
            if (response == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }
        }
        catch (Exception ex)
        {
            Log.d("MainActivity", ex.getLocalizedMessage());
            throw new IOException("Error connecting");
        }
        return in;
    }
    private Bitmap DownloadImage(String URL){
        Bitmap bitmap = null; InputStream in = null;
        try {
            in = OpenHttpConnection(URL);
            bitmap =BitmapFactory.decodeStream(in); in.close();
        } catch (IOException e1) {
            Log.d("NetworkingActivity",
                    e1.getLocalizedMessage());
        }
        return bitmap;
    }
    public class DownloadImageTask extends AsyncTask<String,Void, Bitmap> {
        protected Bitmap doInBackground(String... urls) {
            return DownloadImage(urls[0]);
        }
        protected void onPostExecute(Bitmap result) {
            ImageView img = (ImageView) findViewById(R.id.img);
            img.setImageBitmap(result);
            if (result != null){
                textView.setText("Got image.");
            }
            else{
                textView.setText("Can't get image.");
            }
        }
    }
    public String DownloadText(String URL) {
        int BUFFER_SIZE = 2000;
        InputStream in = null;
        String str = "";
        try {
            in = OpenHttpConnection(URL);
        } catch (IOException e) {
            Log.e("Networking", e.getLocalizedMessage());
            return str;
        }
        if (in == null){
            Log.e("Text URL", "Check connection or URL again!");
            return str;
        }
        try {
            InputStreamReader isr = new InputStreamReader(in);
            int charRead;
            char[] inputBuffer = new char[BUFFER_SIZE];
            while ((charRead = isr.read(inputBuffer)) > 0) {
                //Chuyển chars thành String
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                str += readString;
                inputBuffer = new char[BUFFER_SIZE];
            }
            in.close();
        } catch (IOException e) {
            Log.e("Networking", e.getLocalizedMessage());
            return str;
        }
        return str;
    }

    public class DownloadTextTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return DownloadText(urls[0]);
        }
        @Override
        protected void onPostExecute(String result) {
            TextView textView_2=(TextView)findViewById(R.id.tv);
            textView_2.setText(result);
            if (!result.trim().equals(""))
                tv.setText("Got text.");
            else
                tv.setText("Can't get text.");
        }
    }
    Button btnimg,btntext;
    EditText url1,url2;
    String URL = "192.168.0.101";
    ProgressDialog pd;
    Bitmap bitmap;
    ImageView imgView;
    TextView textView,tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url1 = (EditText)findViewById(R.id.nhapurl1);
        url2 = (EditText)findViewById(R.id.nhapurl2);
        imgView = (ImageView)findViewById(R.id.img);
        textView = (TextView) findViewById(R.id.tvURLimg);

        tv = (TextView) findViewById(R.id.tvURLtext);
        //Thực thi tải dữ liệu hình ảnh
        btnimg = (Button) findViewById(R.id.btn1);
        btnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = url1.getText().toString();
//                    URL url = new URL(url1.getText().toString());
                new DownloadImageTask().execute(url);
//                try {
//                    String url = url1.getText().toString();
////                    URL url = new URL(url1.getText().toString());
//                    new DownloadImageTask().execute(url);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
        });

        //Thực thi tải dữ liệu văn bản
        btntext = (Button) findViewById(R.id.btn2);
        btntext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String url = url2.getText().toString();
                    new DownloadTextTask().execute(url);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}