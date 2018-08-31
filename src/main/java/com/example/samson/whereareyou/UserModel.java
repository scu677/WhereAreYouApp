package com.example.samson.whereareyou;
/***********************************************************************************\
 //Copyright (c) 2018, Resource Innovations Inc.                                    |
 //Created by Samson Ugwuodo on 19/07/2018                                          |
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

public class UserModel {
     int user_id;
     String name;
     String email;
     String password;
     String phone;

    public UserModel(){}

    //Setters
    public void setUser_Id(int user_id){
        this.user_id = user_id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){this.email = email;}
    public void setPassword(String password){this.password = password;}
    public void setPhone(String phone){this.phone = phone;}

    //Getters
    public int getUser_Id(){ return this.user_id; }
    public String getName(){ return this.name; }
    public String getEmail(){return this.email;}
    public String getPassword(){return this.password;}
    public String getPhone(){return  this.phone;}

}
