package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;


import android.Manifest;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.graphics.Color;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import data_repository.Luoghi;
import data_repository.Place;

import static android.widget.ListPopupWindow.WRAP_CONTENT;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback
    ,GoogleMap.OnInfoWindowClickListener

{

    public final static int LOCATION_PERMISSION_REQUEST_CODE = 1;

    Luoghi places;
    private GoogleMap mMap;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Toolbar toolbar = findViewById(R.id.id_tool_maps);
        setSupportActionBar(toolbar);


       adView = findViewById(R.id.ban_id);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("9AFCCCEC6243BF4D142EFF1DCE56CF9B").build();
        adView.loadAd(adRequest);


        /*MobileAds.initialize(getApplicationContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                Toast.makeText(getApplicationContext(),"Advertisement initialized",Toast.LENGTH_LONG).show();
            }
        });*/

        places = new Luoghi();






    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMyLocationButtonClickListener(onMyLocationButtonClickListener);
        mMap.setOnMyLocationClickListener(onMyLocationClickListener);
        enableMyLocationIfPermitted();
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMinZoomPreference(5);


        BitmapDescriptor iconmk = BitmapDescriptorFactory.fromResource(R.drawable.iconkebab);

/*
        for (int i=0;i<places.Labels.size();i++) {


            LatLng arena = new LatLng(places.Labels.get(i).lat, places.Labels.get(i).lng);
            MarkerOptions mko = new MarkerOptions();
            mko.position(arena);
            Marker mk = mMap.addMarker(mko);
            mk.setIcon(iconmk);
            mk.setTag(places.Labels.get(i));


        }

            */

        for (int i=0;i<places.Labels.size();i++) {


            LatLng arena = findCoordinatesByAddress(places.Labels.get(i).address);
            MarkerOptions mko = new MarkerOptions();
            mko.position(arena);
            Marker mk = mMap.addMarker(mko);
            mk.setIcon(iconmk);
            mk.setTag(places.Labels.get(i));


        }



        CustomInfoWindow custominfowindow = new CustomInfoWindow(this);
        mMap.setInfoWindowAdapter(custominfowindow);
        mMap.setOnInfoWindowClickListener(this);

    }


    private void enableMyLocationIfPermitted () {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED ) {

                ActivityCompat.requestPermissions(this,
                        new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}
                        ,LOCATION_PERMISSION_REQUEST_CODE);

        } else if (mMap != null) {
            mMap.setMyLocationEnabled(true);
        }
    }


    public LatLng findCoordinatesByAddress(String strAddress) {

        Geocoder coder = new Geocoder(this);
        List<Address> address;
        LatLng position = null;

        try {
            address = coder.getFromLocationName(strAddress, 5);

            if (address == null) return null ;

            Address location = address.get(0);
            position = new LatLng(location.getLatitude(), location.getLongitude());


        } catch (IOException e) {


        };


        return position;

    };


    public void showDefaultLocation () {

        Toast.makeText(this,"Location Permissions not accepted" +
                "Showing default location.",Toast.LENGTH_SHORT).show();

        LatLng Milano = new LatLng(48.827353, 2.2635543);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Milano));

    }

 public GoogleMap.OnMyLocationButtonClickListener onMyLocationButtonClickListener =

         new GoogleMap.OnMyLocationButtonClickListener() {
             @Override
             public boolean onMyLocationButtonClick() {
                 mMap.setMinZoomPreference(5);
                 return false;
             }
         };


  private GoogleMap.OnMyLocationClickListener onMyLocationClickListener =
          new GoogleMap.OnMyLocationClickListener() {
              @Override
              public void onMyLocationClick(@NonNull Location location) {

                  mMap.setMinZoomPreference(5);
                  CircleOptions circleOptions = new CircleOptions();
                  circleOptions.center(new LatLng(location.getLatitude(),
                          location.getLongitude()));

                  circleOptions.radius(200);
                  //circleOptions.fillColor(Color.RED);
                  circleOptions.strokeWidth(3);

                  mMap.addCircle(circleOptions);
              }
          };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_options_menu,menu);
        return true;
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch ( item.getItemId() ) {

            case ( R.id.about ):
                Intent intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
                break;

            case (R.id.esci) :
                setResult(123);
                this.finish();
                break;


        };

        return super.onContextItemSelected(item);
    }

    /*funzione bottone per mail */
    public void contactUs (View arg0) {

        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView=inflater.inflate(R.layout.contact_us, null, false);
        final PopupWindow pw = new PopupWindow(popupView,900,900,true);
        pw.showAtLocation(arg0,17,0,0);
        pw.setFocusable(true);

        Button close = (Button) popupView.findViewById(R.id.btn_close_pw);
        Button send = (Button) popupView.findViewById(R.id.btn_submit);

        final EditText indirizzo = (EditText) popupView.findViewById(R.id.et_ind);
        final EditText nomelocale = (EditText) popupView.findViewById(R.id.et_nameloc);
        final EditText orario = (EditText) popupView.findViewById(R.id.et_datetime);
        final EditText prezzo = (EditText) popupView.findViewById(R.id.et_price);


        final String body_1 = "Indirizzo:";
        final String body_2 = "Prezzo:";
        final String body_3 = "Ora chiusura:";
        final String body_4 = "Nome:";

        close.setOnClickListener(new View.OnClickListener() {

            public void onClick(View popupView) {
                pw.dismiss();
            }
        });

        send.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {

                String r1 = indirizzo.getText().toString();
                String r2 = prezzo.getText().toString();
                String r3 = orario.getText().toString();
                String r4 = nomelocale.getText().toString();
                String  mailtext = body_1 + " " + r1 + "\n" +
                        body_2 + " " + r2 + "\n" +
                        body_3 + " " + r3 + "\n" +
                        body_4 + " " + r4 + "\n";

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"tranesend@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"App_Kebab: Informazioni");
                intent.putExtra(Intent.EXTRA_TEXT,mailtext);
                intent.setType("message/rfc822");
                try {
                    startActivity(Intent.createChooser(intent, "Send mail..."));
                } catch ( ActivityNotFoundException a) {
                    Toast.makeText(MapsActivity.this,"Mail non associata a nessun utente!",Toast.LENGTH_SHORT).show();
                }

            }

        });


    };


    public void reportUs(View view) {

        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View report = inflater.inflate(R.layout.popup_report_dialog,null, false);
        final PopupWindow pw = new PopupWindow(report,900,WRAP_CONTENT,true);
        pw.showAtLocation(view, 17, 0 ,0);

        Button btn1 = (Button) report.findViewById(R.id.btn_report_1);
        Button btn2 = (Button) report.findViewById(R.id.btn_report_2);
        Button btn3 = (Button) report.findViewById(R.id.btn_report_3);
        Button btn4 = (Button) report.findViewById(R.id.btn_close_rep);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), ReportWrongsInfo.class);
                startActivity(intent);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),ReportBugOthers.class);
                    startActivity(intent);
                    pw.dismiss();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ReportBugOthers.class);
                startActivity(intent);
                pw.dismiss();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pw.dismiss();
            }
        });


    };

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intent= new Intent (getApplicationContext(),KebabDetails.class);
        /*
        Place pl = (Place) marker.getTag();
        intent.putExtra("Address",pl.VideoAddress);
        intent.putExtra("Price",pl.price);

        if (pl.ore != null) {
            intent.putExtra("Ora", pl.ore.intValue());
            intent.putExtra("Minuti", pl.minuti.intValue());
        } else {

            intent.putExtra("Ora",-5);

        };
        intent.putExtra("Nome",pl.nome);
        intent.putExtra("PriceM",pl.priceM);
        intent.putExtra("PriceB",pl.priceB);


        startActivity(intent);*/
    }
}


