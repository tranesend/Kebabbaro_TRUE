package com.example.myapplication;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;



public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*Faccio partire direttamente la mappa senza menu principale */
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);


        }



    @Override
    protected void onRestart() {
        super.onRestart();

        /*Faccio partire direttamente la mappa senza menu principale */
        Intent intent = new Intent(this, MapsActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_options_menu, menu);
        return true;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 123) {
            this.finish();
        }
    }
}
