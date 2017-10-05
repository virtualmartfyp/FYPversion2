package com.example.captainhumza.fypversion2.Customer.CustomerClasses;

/**
 * Created by Captain Humza on 9/24/2017.
 */

public class CountryModel {

    String name;
    String prise;
    int imageCode;


    public CountryModel(String name, String isocode , int img){
        this.name=name;
        this.prise=isocode;
        imageCode = img;
    }

    public String getName() {
        return name;
    }
    public int getImageCode(){return imageCode;}

    public String getisoCode() {
        return "Rs:"+prise;
    }
}
