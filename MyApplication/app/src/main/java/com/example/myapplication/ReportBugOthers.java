package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ReportBugOthers extends AppCompatActivity {

    EditText more_info;
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_bug_others);
        more_info = findViewById(R.id.et_report_b);
        adView = findViewById(R.id.ban_id3);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("9AFCCCEC6243BF4D142EFF1DCE56CF9B").build();
        adView.loadAd(adRequest);
    }



    void sendBugs (View view) {

        String infos= more_info.getText().toString();
        String mailtext = "Kebab_name: " + infos;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"tranesend@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT,"App_Kebab: Bug o Altro");
        intent.putExtra(Intent.EXTRA_TEXT,mailtext);
        intent.setType("message/rfc822");
        try {
            startActivity(Intent.createChooser(intent, "Send mail..."));
        } catch ( ActivityNotFoundException a) {
            Toast.makeText(this,"Mail non associata a nessun utente!",Toast.LENGTH_SHORT).show();
        }

    };

    public void closeBugs (View view) {

        this.finish();

    };



}
