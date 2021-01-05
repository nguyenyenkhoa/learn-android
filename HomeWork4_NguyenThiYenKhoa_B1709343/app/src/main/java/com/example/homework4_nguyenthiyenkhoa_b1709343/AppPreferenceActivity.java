package com.example.homework4_nguyenthiyenkhoa_b1709343;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class AppPreferenceActivity extends PreferenceActivity {
//    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        PreferenceManager prefMgr = getPreferenceManager();
//        prefMgr.setSharedPreferencesName("appPreferences");
        //---load the preferences from an XML file---
        addPreferencesFromResource(R.xml.myapppreferences);
    }

}
