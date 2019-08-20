package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import data_repository.Luoghi;

import static data_repository.Luoghi.setContent;

public class ReportWrongsInfo extends AppCompatActivity {

    Spinner spin;
    EditText more_info;
    ArrayAdapter<String> listOfAddress;

    AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_wrongs_info);

        more_info = findViewById(R.id.et_report_w);
        spin = findViewById(R.id.spin_ind_rep);

        checkAvailableAddress();
        listOfAddress.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(listOfAddress);

        adView = findViewById(R.id.ban_id4);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("9AFCCCEC6243BF4D142EFF1DCE56CF9B")
                .build();
        adView.loadAd(adRequest);



    }

    void sendReport (View view) {

        String road = spin.getSelectedItem().toString();
        String infos= more_info.getText().toString();
        String mailtext = "Kebab_name: " + road + "\n" + infos;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"tranesend@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT,"App_Kebab: Informazioni errate");
        intent.putExtra(Intent.EXTRA_TEXT,mailtext);
        intent.setType("message/rfc822");
        try {
            startActivity(Intent.createChooser(intent, "Send mail..."));
        } catch ( ActivityNotFoundException a) {
            Toast.makeText(this,"Mail non associata a nessun utente!",Toast.LENGTH_SHORT).show();
        }

    };

    public void closeReport (View view) {

        this.finish();

    };


    public void checkAvailableAddress() {

        int nrluoghi = Luoghi.setContent().length;
        List<String> availableAdress = new ArrayList<String>();

        for(int i=0; i<nrluoghi; i++) {

            availableAdress.add( Luoghi.setContent()[i].address );

        }


        listOfAddress = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                availableAdress);


    }


}
