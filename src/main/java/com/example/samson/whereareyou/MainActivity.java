package com.example.samson.whereareyou;

/**
 * Created by Samson on 19/07/2018.
 */

import com.example.samson.whereareyou.ActivityModel;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Timestamp;
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
                        Intent gotoActivity1 = new Intent(MainActivity.this, MapActivity.class);
                        startActivity(gotoActivity1);
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

    //home menu selection
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

   /*public void addItemsOnSpinner1() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("Samson");
        list.add("Adrian");
        list.add("Adam");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
    }*/


    // get the selected dropdown list value
    public void createActivityButton() {
        //Spinner spinner1 = (Spinner) findViewById(R.id.editContact);
        Button btnCreate =  findViewById(R.id.buttonCreateActivity);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                //Toast.makeText(MapActivity.this,
                //      "OnClickListener : " +
                //   "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()),
                //    Toast.LENGTH_SHORT).show();
            }

        });
    }


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




