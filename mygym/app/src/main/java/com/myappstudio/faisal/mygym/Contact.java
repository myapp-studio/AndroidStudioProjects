package com.myappstudio.faisal.mygym;

/**
 * Created by faisa on 22/12/2015.
 */
public class Contact {
    private int _id = 0;
    private String _name = "";
    private String _phoneNumber = "";

    public Contact(){
        //Empty constructor
    }

    public Contact(int id, String name, String phoneNumber){
        _id = id;
        _name = name;
        _phoneNumber = phoneNumber;
    }

    public Contact(String name, String phoneNumber){
        _name = name;
        _phoneNumber = phoneNumber;
    }

    public int getId(){
        return _id;
    }

    public String getName(){
        return _name;
    }

    public String getPhoneNumber(){
        return _phoneNumber;
    }

    public void setId(int id){
        _id = id;
    }

    public void setName(String name){
        _name = name;
    }

    public void setPhoneNumber(String phoneNumber){
        _phoneNumber = phoneNumber;
    }
}
