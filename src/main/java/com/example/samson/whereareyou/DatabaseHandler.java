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
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME ="WhereAreYou.db";
    public static final String  TABLE_USERS = "users";
    public static final String  TABLE_ACTIVITIES = "activities";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_PASSWORD = "password";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /*
     * Create new user and activity
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        /*String create_user = " CREATE TABLE " + TABLE_USERS +  " ("+
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_EMAIL + "TEXT, " +
                COLUMN_PASSWORD + "TEXT," +
                COLUMN_PHONE + "TEXT" +") ";*/
        String create_user = " CREATE TABLE users " + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " + " name TEXT, " + " email TEXT," + "password TEXT, " + " phone TEXT) ";

        String create_activity = " CREATE TABLE activities " + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " + " name TEXT, " + " contact TEXT) ";
        db.execSQL(create_user);
        db.execSQL(create_activity);
    }

    /*
     * Update user if already existing
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String update_activity = "DROP TABLE IF EXISTS activities";
        db.execSQL(update_activity);

        String update_user = "DROP TABLE IF EXISTS users";
        db.execSQL(update_user);
        onCreate(db);
    }

}
