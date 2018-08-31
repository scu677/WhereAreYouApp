package com.example.samson.whereareyou;

/***********************************************************************************\
 //Copyright (c) 2018, Resource Innovations Inc.                                    |
 //Created by Samson Ugwuodo on 16/07/2018                                                       |
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
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", activityModel.name);
        values.put("contact", activityModel.contact);
        //values.put("startDate", String.valueOf(activityModel.startDate));
        //values.put("endDate", String.valueOf(activityModel.endDate));
        boolean createSuccessful = db.insert("activities",null,values) > 0 ;
        db.close();
        return createSuccessful;
    }


    private static final String[] allColumns = {
            COLUMN_ID,
            COLUMN_NAME,
            COLUMN_EMAIL,
            COLUMN_PASSWORD,
            COLUMN_PHONE,
    };

    /*
     * CREATE USER TABLE
     */
    public boolean createUser(UserModel userModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", userModel.name);
        values.put("email", userModel.email);
        values.put("password", userModel.password);
        values.put("phone", userModel.phone);
        boolean createSuccessful = db.insert(TABLE_USERS,null,values) > 0 ;
        db.close();
        return createSuccessful;
    }

    //GET A SINGLE USER
    public  UserModel getUser(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS,allColumns,COLUMN_ID + "=?", new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor != null)
            cursor.moveToFirst();
        UserModel userModel = new UserModel();
        //userModel.setUser_Id(cursor.getInt(0));
        return userModel;
    }

    //Method to get list of all users
    public List<UserModel> getUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, allColumns, null,null,null,null,null);
        List<UserModel> userModels = new ArrayList<>();
        //String getuser = "SELECT * FROM users ORDER BY id DESC";

        if(cursor.moveToFirst()){
            do{
                UserModel objUser = new UserModel();
               // objUser.setUser_Id(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
               // objUser.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
               //// objUser.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
                //objUser.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));
              //  objUser.setPhone(cursor.getString(cursor.getColumnIndex(COLUMN_PHONE)));
                userModels.add(objUser);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userModels;
    }

    //UPDATE USER RECORDS

     public int updateUser(UserModel userModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, userModel.getName());
        values.put(COLUMN_EMAIL, userModel.getEmail());
        values.put(COLUMN_PASSWORD, userModel.getPassword());
        values.put(COLUMN_PHONE, userModel.getPhone());

        // updating row
        return db.update(TABLE_USERS, values,
                COLUMN_ID + "=?",new String[] { String.valueOf(userModel.getUser_Id())});
    }

    //Method to get list of all the activities
    public List<ActivityModel> getActivities() {

        List<ActivityModel> activityList = new ArrayList<ActivityModel>();

        String  sql = "SELECT * FROM activities ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String activityName = cursor.getString(cursor.getColumnIndex("name"));
                //int activityContact = Integer.parseInt(cursor.getString(cursor.getColumnIndex("contact")));
                //String activityContact = cursor.getString(cursor.getColumnIndex("contact"));
                //Timestamp activityStart = Timestamp.valueOf(cursor.getString(cursor.getColumnIndex("startDate")));
                 //Timestamp activityEnd = Timestamp.valueOf(cursor.getString(cursor.getColumnIndex("startDate")));

                ActivityModel objectActivity = new ActivityModel();
                objectActivity.id = id;
                objectActivity.name = activityName;
                //objectActivity.contact = activityContact;
                //objectActivity.startDate = activityStart;
               // objectActivity.endDate = activityEnd;

                activityList.add(objectActivity);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return activityList;
    }

}