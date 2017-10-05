package com.example.captainhumza.fypversion2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.captainhumza.fypversion2.Customer.CustomerHomeTwoActivity;
import com.example.captainhumza.fypversion2.Rider.RiderHomeActivity;
import com.example.captainhumza.fypversion2.Vendor.VendorHome;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    Context context;
    TextView signupText,forgotPassword;
    private Spinner spinner1;
    EditText userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addItemsOnSpinner();
        signupText = (TextView) findViewById(R.id.link_signup);
        userName = (EditText)findViewById(R.id.edt_login_id);
    }




    public void addItemsOnSpinner() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("<--Select User Role-->");
        list.add("Vendor");
        list.add("Rider");
        list.add("Customer");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
    }

    public void SignUp(View view) {

        final CharSequence options[] = new CharSequence[] {"Customer", "Shop"};

        Intent signup = new Intent(this , SignUpActivity.class);
        startActivity(signup);
    }

    public void forgotpass(View view) {



        final AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Enter Email");
        final EditText input = new EditText(context);
        input.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        alert.setView(input);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                if (input.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter Email", Toast.LENGTH_SHORT).show();
                } else {
                    String email = (input.getText().toString());


                }
            }});
    }

    public void Login_Button(View view) {
        Toast.makeText(this,"button clicked",Toast.LENGTH_SHORT).show();
        String userNameThis = userName.getText().toString();
        if (userNameThis.equals("vender"))
        {

            Intent intent = new Intent(this , VendorHome.class);
            startActivity(intent);
        }else if (userNameThis.equals("customer"))
        {

            Intent intent = new Intent(this , CustomerHomeTwoActivity.class);
            startActivity(intent);
        }else if (userNameThis.equals("rider"))
        {

            Intent intent = new Intent(this , RiderHomeActivity.class);
            startActivity(intent);
        }

    }
}
