package com.example.samson.whereareyou;

/**
 * Created by Samson on 23/07/2018.
 */

public class ContactModel {
    int id;
    String name;
    String phone;


    public ContactModel(){

    }

    public void setId(int id){

        this.id = id;
    }

    public void  setName(String name){

        this.name = name;
    }


    public int getId(){

        return this.id;
    }

    public  String getName(){

        return this.name;
    }

    public String getPhone(){
        return this.phone;
    }


}
