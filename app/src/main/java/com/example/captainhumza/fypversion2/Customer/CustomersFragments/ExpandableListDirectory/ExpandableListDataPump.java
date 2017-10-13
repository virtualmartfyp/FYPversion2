package com.example.captainhumza.fypversion2.Customer.CustomersFragments.ExpandableListDirectory;

import com.example.captainhumza.fypversion2.Classes.ProductCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Captain Humza on 10/5/2017.
 */

public class ExpandableListDataPump {
    public static List<ProductCategory> productCategories = new ArrayList<ProductCategory>();
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        String[] product = {"Pepsi" , "Prince" , "pasta" , "Choclato" , "ponam" , "Shan Masla" , "National Masala" , "Habib cooking oil"};
        for(int a = 0; a < productCategories.size();a++)
        {
            List<String> basketball1 = new ArrayList<String>();
            basketball1.add(productCategories.get(a).productTitle);
            expandableListDetail.put(productCategories.get(a).productTitle, basketball1);
        }
        return expandableListDetail;
    }
}
