package com.example.myapplication;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import app_utilities.TimeData;

import java.util.Calendar;

import data_repository.Place;

public class CustomInfoWindow implements GoogleMap.InfoWindowAdapter {


    private Context context;

    public CustomInfoWindow(Context ctx) {
        context = ctx;
    }


    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {

        View view = ((Activity) context).getLayoutInflater()
                .inflate(R.layout.custom_window, null);


        TextView add = view.findViewById(R.id.add);
        TextView prix = view.findViewById(R.id.prix);
        TextView commento = view.findViewById(R.id.descr);
        ImageView staticeur = view.findViewById(R.id.static_eur);
        TextView orario = view.findViewById(R.id.tv_fixtime);


        Place pl = (Place) marker.getTag();
        add.setText(pl.VideoAddress);
        prix.setText(pl.price);
        commento.setText(pl.nome);


        if (pl.ore != null && pl.minuti != null) {

            if (pl.ore.intValue() == -1) {
                orario.setText("24h");

            } else if (pl.ore.intValue() == 24) {

                orario.setText("00:" + TimeData.numberToTime(pl.minuti));

            } else
                orario.setText(TimeData.numberToTime(pl.ore) + ":" + TimeData.numberToTime(pl.minuti));

        }


        return view;

    }

}



