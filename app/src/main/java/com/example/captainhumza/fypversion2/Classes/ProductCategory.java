package com.example.captainhumza.fypversion2.Classes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.captainhumza.fypversion2.Customer.CustomerHomeTwoActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Captain Humza on 10/11/2017.
 */

public class ProductCategory {

    public int productTitleId ;
    public String productTitle ;
    public byte[] productTitleImage ;
    public String category ;
    public Bitmap decodedByte;
    String test = "";
    String showUrl = "http://192.168.10.5/FYP_Version1/api/ProductsApi";
    String insert = "http://10.0.2.2/captain/addform.php";
    RequestQueue referenceQueue;
    public List<ProductCategory>  GetAllProductsCategory() {
        final List<ProductCategory> productCategoriesLs = new ArrayList<ProductCategory>() {
        };
        try {
            referenceQueue = Volley.newRequestQueue(CustomerHomeTwoActivity.instance().getApplicationContext());
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, showUrl
                    , null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {

                        JSONArray st = response.getJSONArray("Value");
                        for (int i = 0; i < st.length(); i++) {
                            ProductCategory pc = new ProductCategory();
                            JSONObject str = st.getJSONObject(i);
                            pc.productTitle = str.getString("productTitle");
                            pc.productTitleId = str.getInt("productTitleId");
                            String ab = str.getString("productTitleImage");
                            pc.category = str.getString("category");
                            if (ab.length() > 6)
                            {
                                byte[] decodedString = Base64.decode(ab,0);
                                pc.decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                                //pc.productTitleImage = decodedString;
                            }

                            productCategoriesLs.add(pc);

                        }

                    } catch (JSONException e) {
                        test = test + (e.getMessage());
                        e.printStackTrace();
                    }


                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            referenceQueue.add(jsonObjectRequest);
        } catch (Exception ex) {
            test = test + (ex.getMessage());
        }
        return productCategoriesLs;

    }
    public byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        return stream.toByteArray();
    }

}
