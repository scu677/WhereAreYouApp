package com.example.samson.whereareyou;

/**
 * Created by Samson on 19/07/2018.
 */

public class UserModel {
    int id;
    String name;
    String password;
    String phone;
    String email;

    public UserModel(){

    }

    //Setters
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){this.password = password;}
    public void setEmail(String Email){this.email = email;}

    //Getters
    public int getId(){ return this.id; }
    public String getName(){
        return this.name;
    }
    public String getPassword(){return this.password;}
    public String getEmail(){return this.email;}


    public void getUsers(){}
    public void getuser(){}
    public void update(){}
}
