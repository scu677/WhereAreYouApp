package com.example.samson.whereareyou;
/***********************************************************************************\
 //Copyright (c) 2018, Resource Innovations Inc.                                    |
 //Created by Samson Ugwuodo on 19/07/2018.                                                      |
 // MainActivity source code                                                        |
 // Licensed under the Apache License, Version 2.0 (the "License");                 |
 // you may not use this file except in compliance with the License.                |
 // You may obtain a copy of the License at                                         |
 // http://www.apache.org/licenses/LICENSE-2.0                                      |
 // Unless required by applicable law or agreed to in writing, software             |
 // distributed under the License is distributed on an "AS IS" BASIS,               |
 // WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.        |
 // See the License for the specific language governing permissions and             |
 //limitations under the License.                                                   |
 \*********************************************************************************/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.maps.GoogleMap;

public class MapActivity extends AppCompatActivity {
    private GoogleMap mMap;
    private MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_activity_form);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

