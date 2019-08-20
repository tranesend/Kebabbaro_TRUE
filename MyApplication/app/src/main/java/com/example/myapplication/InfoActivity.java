package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class InfoActivity extends AppCompatActivity {

    AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        adView = findViewById(R.id.ban_id2);

        AdRequest adRequest = new AdRequest.Builder().addTestDevice("9AFCCCEC6243BF4D142EFF1DCE56CF9B").build();
        adView.loadAd(adRequest);
    }




}
