package com.example.dreambuild;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Report extends AppCompatActivity {
    Button submitReport ;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    EditText inputReport;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        //This line Hides Action Bar(Top Bar)
        getSupportActionBar().hide();


        submitReport=findViewById(R.id.submitReport);
        inputReport=findViewById(R.id.ReportText);
        progressDialog=new ProgressDialog(this);
        submitReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                submitReport();

    }

    private void submitReport() {


        String report = inputReport.getText().toString();

        if (report.isEmpty()) {
            inputReport.setError("Enter Text in The Field");

        }
            else{
            progressDialog.setMessage("Please Wait While We Submit Your Report...");
            progressDialog.setTitle("Submission");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();


        Map<String, Object> hashMap = new HashMap();
        hashMap.put("Report", report);

        db.collection("User").document("Report").set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(Report.this, "Report Submitted", Toast.LENGTH_LONG);
                progressDialog.dismiss();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Report.this, e.toString(), Toast.LENGTH_SHORT);
                progressDialog.dismiss();

            }
        });
    }

    }
});

    }
}