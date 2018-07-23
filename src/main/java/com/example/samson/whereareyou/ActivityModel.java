package com.example.samson.whereareyou;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Samson on 17/07/2018.
 */

public class ActivityModel {
    int id;
    String name;
    int user;
    int contact;
    String startDate;
    String endDate;
    private SQLiteDatabase writableDatabase;

    //constructor
    public ActivityModel() {


   }
    //setters
    public void setId(int id){

        this.id = id;
    }
     public void setName(String name){
        this.name =name;
     }
    public void setUser(int user){
         this.user = user;
    }
    public void setContact(int contact){
        this.contact = contact;
    }
    public void setStartDate(String startDate){
        this.startDate = startDate;
    }

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }


    //getters
   public void getActivities(){
        //getActivities();
   }


   public void getActivityFor(){}

   public void deleteActivity(){}

   public void updateAcivity(){}



}
