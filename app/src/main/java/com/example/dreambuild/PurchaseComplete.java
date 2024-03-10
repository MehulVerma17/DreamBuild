package com.example.dreambuild;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PurchaseComplete extends AppCompatActivity {
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10,
            textView11,textView12,textView13,textView14,textView15,textView16,textView17,textView18,textView19;

    Button back;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference refProcessor=db.collection("User").document("Processor");
    DocumentReference refMotherboard=db.collection("User").document("Motherboard");
    DocumentReference refGraphicsCard=db.collection("User").document("GraphicsCard");
    DocumentReference refPowerSupply=db.collection("User").document("PowerSupply");
    DocumentReference refCabinets=db.collection("User").document("Cabinets");
    DocumentReference refMemory=db.collection("User").document("Memory");
    DocumentReference refHardDrives=db.collection("User").document("HardDrives");
    DocumentReference refSSD=db.collection("User").document("SSD");
    DocumentReference refCoolers=db.collection("User").document("Coolers");
    DocumentReference refTotalAmount=db.collection("User").document("Total Amount");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchasecomplete);

        //This line Hides Action Bar(Top Bar)
        getSupportActionBar().hide();

        textView1=findViewById(R.id.textView41);
        textView2=findViewById(R.id.textView42);
        textView3=findViewById(R.id.textView60);
        textView4=findViewById(R.id.textView61);
        textView5=findViewById(R.id.textView62);
        textView6=findViewById(R.id.textView69);
        textView7=findViewById(R.id.textView63);
        textView8=findViewById(R.id.textView70);
        textView9=findViewById(R.id.textView64);
        textView10=findViewById(R.id.textView71);
        textView11=findViewById(R.id.textView65);
        textView12=findViewById(R.id.textView72);
        textView13=findViewById(R.id.textView66);
        textView14=findViewById(R.id.textView73);
        textView15=findViewById(R.id.textView67);
        textView16=findViewById(R.id.textView74);
        textView17=findViewById(R.id.textView68);
        textView18=findViewById(R.id.textView75);
        textView19=findViewById(R.id.textView76);


        refProcessor.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()) {
                    Object price = documentSnapshot.get("Processor Amount");
                    String Name= documentSnapshot.getString("Processor Name");
                    textView1.setText(Name);
                    textView2.setText(price.toString());

                }
            }
        });

        refMotherboard.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()) {
                    Object price1 = documentSnapshot.get("MotherBoard Amount");
                    String Name1= documentSnapshot.getString("MotherBoard Name");
                    textView3.setText(Name1);
                    textView4.setText(price1.toString());

                }
            }
        });

        refGraphicsCard.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()) {
                    Object price2 = documentSnapshot.get("GraphicsCard Amount");
                    String Name2= documentSnapshot.getString("GraphicsCard Name");
                    textView5.setText(Name2);
                    textView6.setText(price2.toString());

                }
            }
        });

        refPowerSupply.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()) {
                    Object price3 = documentSnapshot.get("PowerSupply Amount");
                    String Name3= documentSnapshot.getString("PowerSupply Name");
                    textView7.setText(Name3);
                    textView8.setText(price3.toString());

                }
            }
        });

        refCabinets.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()) {
                    Object price4 = documentSnapshot.get("Cabinets Amount");
                    String Name4= documentSnapshot.getString("Cabinets Name");
                    textView9.setText(Name4);
                    textView10.setText(price4.toString());

                }
            }
        });

        refMemory.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()) {
                    Object price5 = documentSnapshot.get("Memory Amount");
                    String Name5= documentSnapshot.getString("Memory Name");
                    textView11.setText(Name5);
                    textView12.setText(price5.toString());

                }
            }
        });

        refHardDrives.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()) {
                    Object price6 = documentSnapshot.get("HardDrive Amount");
                    String Name6= documentSnapshot.getString("HardDrive Name");
                    textView13.setText(Name6);
                    textView14.setText(price6.toString());

                }
            }
        });

        refSSD.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()) {
                    Object price7 = documentSnapshot.get("SSD Amount");
                    String Name7= documentSnapshot.getString("SSD Name");
                    textView15.setText(Name7);
                    textView16.setText(price7.toString());

                }
            }
        });


        refCoolers.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    Object price8 = documentSnapshot.get("Cooler Amount");
                    String Name8 = documentSnapshot.getString("Cooler Name");
                    textView17.setText(Name8);
                    textView18.setText(price8.toString());

                }
            }
        });

        refTotalAmount.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    Object amount = documentSnapshot.get("Total Amount");
                    textView19.setText(amount.toString());

                }
            }
        });

        back=findViewById(R.id.button4);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PurchaseComplete.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}