package com.example.samson.whereareyou;

/**
 * Created by Samson on 19/07/2018.
 */


import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout myDrawerLayout;
    private MapActivity map_activity;
    //private Spinner spinner1;
    //private Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        myDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setCheckable(true);
                switch (item.getItemId()) {
                    case R.id.nav_contact:
                        myDrawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_activity:

                        Intent gotoActivity1 = new Intent(MainActivity.this, MapActivity.class);
                        startActivity(gotoActivity1);
                        //myDrawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_create:

                        //Intent gotoActivity = new Intent(MainActivity.this, MapActivity.class);
                        //startActivity(gotoActivity);
                       myDrawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_logout:
                        myDrawerLayout.closeDrawers();
                        return true;
                }
                return true;
            }
        });

        //addItemsOnSpinner1();
       // createActivityButton();
        //readRecords();
    }

   /* public void readRecords() {

        LinearLayout linearLayoutRecords = (LinearLayout) findViewById(R.id.linearLayoutRecords);
        linearLayoutRecords.removeAllViews();

        List<ActivityModel> students = new ActivityTableController(this).read();

        if (students.size() > 0) {

            for (ActivityModel obj : students) {

                int id = obj.id;
                String activityName = obj.name;


                String textViewContents = activityName;

                TextView textViewStudentItem= new TextView(this);
                textViewStudentItem.setPadding(0, 10, 0, 10);
                textViewStudentItem.setText(textViewContents);
                textViewStudentItem.setTag(Integer.toString(id));

                linearLayoutRecords.addView(textViewStudentItem);
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
    /*public void createActivityButton() {
        // spinner1 = (Spinner) findViewById(R.id.spinner1);
        Button btnCreate =  findViewById(R.id.buttonCreateActivity);
        btnCreate.setOnClickListener(new View.OnClickListener() {

            //@Override
            public void onClick(View v) {
                EditText editActivityName = findViewById(R.id.editActivityName);
                EditText editContact = findViewById(R.id.editContacts);
                EditText editStartDateTime = findViewById(R.id.editStartDateTime);
                EditText editEndDateTime = findViewById(R.id.editEndDateTime);
                String ActivityName = editActivityName.getText().toString();
                String ActivityContact = editContact.getText().toString();
                String ActivityStart = editStartDateTime.getText().toString();
                String ActivityEnd = editEndDateTime.getText().toString();

                ActivityModel activityObject = new ActivityModel();

                activityObject.name = ActivityName;
                activityObject.contact = ActivityContact;
                activityObject.startDate = ActivityStart;
                activityObject.endDate = ActivityEnd;

                boolean createSuccessful = new ActivityTableController(MainActivity.this).createActivity(activityObject);

                if(createSuccessful){
                    Toast.makeText(MainActivity.this, "Activity was created successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Unable to create Activity", Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(MapActivity.this,
                //      "OnClickListener : " +
                //   "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()),
                //    Toast.LENGTH_SHORT).show();
            }

        });
    }*/




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




