package com.example.captainhumza.fypversion2.Customer.CustomersFragments.ExpandableListDirectory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Captain Humza on 10/5/2017.
 */

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> cricket = new ArrayList<String>();
        cricket.add("India");
        cricket.add("Pakistan");
        cricket.add("Australia");
        cricket.add("England");
        cricket.add("South Africa");

        List<String> football = new ArrayList<String>();
        football.add("Brazil");
        football.add("Spain");
        football.add("Germany");
        football.add("Netherlands adaljdslkajd asjdlkajsdlk a");
        football.add("Italy");

        List<String> basketball = new ArrayList<String>();
        basketball.add("United States");
        basketball.add("Spain");
        basketball.add("Argentina");
        basketball.add("France");
        basketball.add("Russia");

        expandableListDetail.put("Sunsilk", cricket);
        expandableListDetail.put("Capri", football);
        expandableListDetail.put("Saltish", basketball);
        String[] product = {"Pepsi" , "Prince" , "pasta" , "Choclato" , "ponam" , "Shan Masla" , "National Masala" , "Habib cooking oil"};
        for(int a = 0; a < product.length;a++)
        {
            List<String> basketball1 = new ArrayList<String>();
            basketball1.add("United States"+a);
            basketball1.add("Spain"+a);
            basketball1.add("Argentina"+a);
            basketball1.add("France"+a);
            basketball1.add("Russia"+a);
            expandableListDetail.put(product[a], basketball1);
        }
        return expandableListDetail;
    }
}
