package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;

import app_utilities.TimeData;

public class KebabDetails extends AppCompatActivity {

    TextView address;
    TextView price;
    TextView orario;
    TextView nome;
    TextView closeUntil;
    TextView priceS;
    TextView priceM;
    TextView priceB;
    ImageView kebab_S;
    ImageView kebab_M;
    ImageView kebab_B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kebab_details);


        getOrarioDetail();
        getAddressDetail();
        getNameDetail();
        getPriceDetail();
        //getCloseUntil();

        getPricesDetails();
        getImagesDetails();

    }

    /*public void getCloseUntil() {

        Bundle extras  = getIntent().getExtras();
        int ora = extras.getInt("Ora");
        int minuti = extras.getInt("Minuti");

        closeUntil = findViewById(R.id.tv_closeUntil);
        closeUntil.setText(TimeData.openedUntil(ora,minuti));

    };*/

    public void getOrarioDetail() {

        orario = findViewById(R.id.tv_dts_fixtime);
        Bundle extras = getIntent().getExtras();

        int ora = extras.getInt("Ora");
        int minuti = extras.getInt("Minuti");

        if (ora != -5) {

            String txt_ora = TimeData.intToTime(ora);
            String txt_min = TimeData.intToTime(minuti);
            String text_orario;

            if (txt_ora == "-1") {
                text_orario = "24h";
            } else text_orario = txt_ora + ":" + txt_min;

            orario.setText(text_orario);


        }

    };

    public void getAddressDetail() {

        address = findViewById(R.id.tv_dts_add);
        Bundle extras = getIntent().getExtras();
        String txt_add = extras.getString("Address");
        address.setText(txt_add);


    };

    public void getNameDetail(){

        nome = findViewById(R.id.tv_dts_descr);
        Bundle extras = getIntent().getExtras();
        String txt_nome = extras.getString("Nome");
        nome.setText(txt_nome);

    };

    public void getPriceDetail(){

        price = findViewById(R.id.tv_dts_prc);
        Bundle extras = getIntent().getExtras();
        String txt_price = extras.getString("Price");
        price.setText(txt_price);

    };

    public void getPricesDetails() {

        priceS = findViewById(R.id.tv_dts_kebab_S);
        priceM = findViewById(R.id.tv_dts_kebab_M);
        priceB = findViewById(R.id.tv_dts_kebab_B);
        Bundle extras = getIntent().getExtras();
        String txt_priceS = extras.getString("Price");
        String txt_priceM = extras.getString("PriceM");
        String txt_priceB = extras.getString("PriceB");

        priceS.setText(txt_priceS);
        priceM.setText(txt_priceM);
        priceB.setText(txt_priceB);



    }

    public void getImagesDetails() {

        kebab_S = findViewById(R.id.imv_dts_kebab_S);
        kebab_M = findViewById(R.id.imv_dts_kebab_M);
        kebab_B = findViewById(R.id.imv_dts_kebab_B);

        kebab_S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Prezzo kebab piccolo",Toast.LENGTH_SHORT).show();

            }
        });


        kebab_M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Prezzo kebab medio",Toast.LENGTH_SHORT).show();

            }
        });


        kebab_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Prezzo kebab grande",Toast.LENGTH_SHORT).show();

            }
        });



    };



}
