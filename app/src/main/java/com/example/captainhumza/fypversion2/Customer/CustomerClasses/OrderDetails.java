package com.example.captainhumza.fypversion2.Customer.CustomerClasses;

import java.util.Date;

/**
 * Created by Captain Humza on 9/24/2017.
 */

public class OrderDetails {

    String name;
    String prise;
    int imageCode;
    Date date;

    public OrderDetails(int i){

        date = new Date(2017,9,i,12,50);
    }
    public OrderDetails(String name, String isocode , int img){
        this.name=name;
        this.prise=isocode;
        imageCode = img;
    }
    public String getDate(){return date.toString();}
    public String getName() {
        return name;
    }
    public int getImageCode(){return imageCode;}

    public String getisoCode() {
        return "Rs:"+prise;
    }
}
