package com.example.samson.whereareyou;

/**
 * Created by Samson on 19/07/2018.
 */

public class UserModel {
    int id;
    String name;
    String username;
    String phone;
    String email;


    public UserModel(){

    }

    //setters
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getId(){

        return this.id;
    }
    public String getName(){
        return this.name;
    }


    public void getUsers(){}
    public void getuser(){}
    public void update(){}
}
