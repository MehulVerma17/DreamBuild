package com.example.dreambuild;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Address extends AppCompatActivity {

    Button buyNow;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    EditText inputName,inputPhone,inputAddress,inputZipcode;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);


        inputName=findViewById(R.id.inputName);
        inputPhone=(EditText) findViewById(R.id.inputNumber);
        inputAddress=findViewById(R.id.inputAddress);
        inputZipcode=findViewById(R.id.inputZipcode);
        progressDialog=new ProgressDialog(this);



        String states[]={"New Delhi","Goa","Haryana","Gujarat","Maharashtra","Chhattisgarh"};


        //This line Hides Action Bar(Top Bar)
        getSupportActionBar().hide();

        //states Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, states);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> spinner, View view, int pos, long id) {
                Object item = spinner.getItemAtPosition(pos);
               String inputState=item.toString();
                Map<String, Object> hashMap = new HashMap();
               hashMap.put("State",inputState);
                db.collection("User").document("State").set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Address.this, "State Set", Toast.LENGTH_SHORT);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Address.this, e.toString(), Toast.LENGTH_SHORT);


                    }
                });
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        buyNow=findViewById(R.id.buyNow);
        buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                submitDetails();

            }
        });

    }

    private void submitDetails() {
        String name=inputName.getText().toString();
        String address=inputAddress.getText().toString();
        String stringPhone=inputPhone.getText().toString();
        String stringZipcode=inputZipcode.getText().toString();

        Long phone=Long.parseLong(inputPhone.getText().toString());
        int zipcode=Integer.parseInt(inputZipcode.getText().toString());

        if (name.isEmpty() || address.isEmpty() || stringPhone.length()==0 || stringZipcode.length()==0) {
            Toast.makeText(this, "! Please Fill all Fields", Toast.LENGTH_SHORT).show();

        }
        else if(name.isEmpty() && address.isEmpty() && stringPhone.isEmpty() && stringZipcode.isEmpty()){
            Toast.makeText(this, "! Please Fill all Fields", Toast.LENGTH_SHORT).show();

        }
        else {
            progressDialog.setMessage("Please Wait While We Submit Your Details...");
            progressDialog.setTitle("Submission");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();


            Map<String, Object> hashMap = new HashMap();
            hashMap.put("Name", name);
            hashMap.put("Phone Number", phone);
            hashMap.put("Address", address);
            hashMap.put("Zipcode", zipcode);

            db.collection("User").document("Data").set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(Address.this, "Purchase Complete!", Toast.LENGTH_SHORT);
                    progressDialog.dismiss();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Address.this, e.toString(), Toast.LENGTH_SHORT);
                    progressDialog.dismiss();

                }
            });
            Intent intent = new Intent(Address.this, PurchaseComplete.class);
            startActivity(intent);
        }
    }

}