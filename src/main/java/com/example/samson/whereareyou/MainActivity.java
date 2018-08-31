package com.example.samson.whereareyou;
/***********************************************************************************\
 //Copyright (c) 2018, Resource Innovations Inc.                                    |
 //Created by Samson Ugwuodo on 19/07/2018.                                         |
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

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class  MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DrawerLayout myDrawerLayout;
    private MapActivity map_activity;
    DatabaseHandler mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        mydb = new DatabaseHandler(this);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        myDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setCheckable(true);
                switch (item.getItemId()) {
                    case R.id.nav_profile:
                        Intent createAccount = new Intent(MainActivity.this, Registration.class);
                        startActivity(createAccount);
                        myDrawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_contact:
                       //Add activity here to create new contacts
                        return true;
                    case R.id.nav_login:
                        Intent gotoLogin = new Intent(MainActivity.this, Login.class);
                        startActivity(gotoLogin);
                        myDrawerLayout.closeDrawers();
                        return true;
                }
                return true;
            }
        });

        for(int i = 0; i < btn.length; i++){
            btn[i] = (Button) findViewById(btn_id[i]);
            btn[i].setOnClickListener(this);
        }

    }

    /*
     * Main screen menu selection button
     */
    Button[] btn = new Button[3];
    private int[] btn_id = new int[]{R.id.btnActivity, R.id.btnCreateActivity, R.id.btnContact};
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnActivity:
                readRecords();
                break;
            case R.id.btnCreateActivity:
                Intent gotoActivity1 = new Intent(MainActivity.this, MapActivity.class);
                startActivity(gotoActivity1);
                break;
            case R.id.btnContact:
                break;
        }

    }

   /*
    * Method for reading the list of created activities
    */
   public void readRecords() {

        LinearLayout linearLayoutRecords = (LinearLayout) findViewById(R.id.linearLayoutRecords);
        linearLayoutRecords.removeAllViews();
        List<ActivityModel> activity = new ActivityTableController(this).getActivities();

        if (activity.size() > 0) {

            for (ActivityModel obj : activity) {

                int id = obj.id;
                String activityName = obj.name;
                String textViewContents = activityName;
                TextView textActivityItem = new TextView(this);
                textActivityItem.setPadding(0, 10, 0, 10);
                textActivityItem.setText(textViewContents);
                textActivityItem.setTag(Integer.toString(id));
                linearLayoutRecords.addView(textActivityItem);
            }

        }

        else {

            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);
            locationItem.setText("No records yet.");
            linearLayoutRecords.addView(locationItem);
        }
    }


    /*
     * Drawer menu control
     */
    public boolean onOptionsItemSelected(MenuItem item){

         switch (item.getItemId()){
             case android.R.id.home:
                if (myDrawerLayout.isDrawerOpen(Gravity.START)){
                    myDrawerLayout.closeDrawer(GravityCompat.START);
                }else{myDrawerLayout.openDrawer(GravityCompat.START);}
             return true;
         }
        return super.onOptionsItemSelected(item);
    }

}




