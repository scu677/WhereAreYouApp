package com.example.samson.whereareyou;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samson on 16/07/2018.
 */

public class ActivityTableController extends DatabaseHandler {
    public ActivityTableController(Context context) {
        super(context);
    }

    public boolean createActivity(ActivityModel activityModel){

        ContentValues values = new ContentValues();
        values.put("name", activityModel.name);
        values.put("contact", activityModel.contact);
        values.put("startDate", activityModel.startDate);
        values.put("endDate", activityModel.endDate);
        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("activities",null,values) > 0 ;
        db.close();
        return createSuccessful;
    }

    public List<ActivityModel> getActivities() {

        List<ActivityModel> activityList = new ArrayList<ActivityModel>();

        String sql = "SELECT * FROM activities ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String activityName = cursor.getString(cursor.getColumnIndex("name"));
                int activityContact = Integer.parseInt(cursor.getString(cursor.getColumnIndex("contact")));
               String activityStart = cursor.getString(cursor.getColumnIndex("startDate"));
               String activityEnd = cursor.getString(cursor.getColumnIndex("startDate"));

                ActivityModel objectActivity = new ActivityModel();
                objectActivity.id = id;
                objectActivity.name = activityName;
                objectActivity.contact = activityContact;
                objectActivity.startDate = activityStart;
               objectActivity.endDate = activityEnd;

                activityList.add(objectActivity);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return activityList;
    }





}