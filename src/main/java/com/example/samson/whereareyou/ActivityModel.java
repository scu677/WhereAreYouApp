package com.example.samson.whereareyou;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.example.samson.whereareyou.MainActivity;
import com.example.samson.whereareyou.ActivityTableController;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

/**
 * Created by Samson on 17/07/2018.
 */

public class ActivityModel {
    int id;
    //int user;
    String contact;
    String name;
    Timestamp startDate;
    Timestamp endDate;

    private SQLiteDatabase writableDatabase;
    //constructor
    public ActivityModel() {

   }
    //Setters
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
     }
   // public void setUser(int user){ this.user = user; }
    public void setContact(String contact){this.contact = contact; }
    public void setStartDate(Timestamp startDate){ this.startDate = startDate; }
    public void setEndDate(Timestamp endDate){ this.endDate = endDate; }

    //Getters
    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public String getContact(){return this.contact;}
    public Timestamp getStartDate(){return this.startDate;}
    public Timestamp getEndDate(){return this.endDate;}


    //get a selected activities
    public int getActivityFor(int id){
        return 0;
    }

    //get list of all activities
    public void getActivityFor(){}

    public void deleteActivity(){}

    public void updateAcivity(){}

}
