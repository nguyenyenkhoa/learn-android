package com.example.bai13_buoi6_nguyenthiyenkhoa_b1709343;

import android.app.Application;

public class WifiApp extends Application {
    static WifiApp wifiInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        wifiInstance = this;
    }
    public static synchronized WifiApp getInstance() {
        return wifiInstance;
    }
}

