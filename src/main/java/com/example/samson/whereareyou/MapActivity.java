package com.example.samson.whereareyou;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.sql.Timestamp;

/**
 * Created by Samson on 19/07/2018.
 */


public class MapActivity extends AppCompatActivity {
    private GoogleMap mMap;
    private MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_activity_form);
        //setContentView(R.layout.activity_maps);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //mainActivity.createActivityButton();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        //SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
       // mapFragment.getMapAsync(this);
       createActivityButton();
    }

    public void createActivityButton() {
        Button btnCreate =  findViewById(R.id.btnCreateActivity);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                //createActivity();

                EditText editActivityName = findViewById(R.id.editActivityName);
                EditText editContact = findViewById(R.id.editContact);
                //EditText editStartDateTime = findViewById(R.id.editStartDateTime);
                //EditText editEndDateTime = findViewById(R.id.editEndDateTime);

                String ActivityName = editActivityName.getText().toString();
                String ActivityContact = editContact.getText().toString();
               // Timestamp ActivityStart = Timestamp.valueOf(editStartDateTime.getText().toString());
                //Timestamp ActivityEnd = Timestamp.valueOf(editEndDateTime.getText().toString());

                ActivityModel activityObject = new ActivityModel();
                activityObject.name = ActivityName;
                activityObject.contact = ActivityContact;
               // activityObject.startDate = ActivityStart;
                //activityObject.endDate = ActivityEnd;

                boolean createSuccessful = new ActivityTableController(MapActivity.this).createActivity(activityObject);
                if(createSuccessful){
                    Toast.makeText(MapActivity.this, "Activity was created successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MapActivity.this, "Unable to create Activity", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }


    //public void createActivity(){
        //Spinner spinner1 = (Spinner) findViewById(R.id.editContact)
    //}

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

   /* @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(new LatLng(0,0)).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }*/


}

