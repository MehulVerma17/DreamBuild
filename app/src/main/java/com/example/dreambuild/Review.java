package com.example.dreambuild;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Review extends AppCompatActivity {
    Button submitReview ;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    EditText inputReview;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        //This line Hides Action Bar(Top Bar)
        getSupportActionBar().hide();

        progressDialog=new ProgressDialog(this);

        submitReview=findViewById(R.id.submitReview);
        inputReview=findViewById(R.id.ReviewText);

        submitReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitReview();


            }
        });


    }

    private void submitReview() {

        String review = inputReview.getText().toString();

        if (review.isEmpty()) {
            inputReview.setError("Enter Text in The Field");

        }
        else{
            progressDialog.setMessage("Please Wait While We Submit Your Review...");
            progressDialog.setTitle("Submission");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();


            Map<String, Object> hashMap = new HashMap();
            hashMap.put("Review", review);

            db.collection("User").document("Review").set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(Review.this, "Review Submitted", Toast.LENGTH_LONG);
                    progressDialog.dismiss();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Review.this, e.toString(), Toast.LENGTH_SHORT);
                    progressDialog.dismiss();

                }
            });
        }
    }
}