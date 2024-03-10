package com.example.dreambuild;

import static android.widget.Toast.makeText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signup extends AppCompatActivity {

    EditText inputEmail,inputPassword;
    Button GoToLogin,CreateAccount;
    String emailPattern="[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";


    FirebaseAuth mAuth;
    FirebaseUser mUser;

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //This line Hides Action Bar(Top Bar)
        getSupportActionBar().hide();


        inputEmail=findViewById(R.id.editTextTextEmailAddress2);
        inputPassword=findViewById(R.id.editTextTextPassword2);
        CreateAccount=findViewById(R.id.button6);

        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        progressDialog=new ProgressDialog(this);

        CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performAuth();
            }
        });



        GoToLogin=findViewById(R.id.button9);

        GoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void performAuth() {
        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();


        if(!email.matches(emailPattern)){
            inputEmail.setError("Enter Correct Email");
        }
        else if(password.isEmpty() || password.length()<6){
            inputPassword.setError("Enter Proper Password");

        }
        else{

            progressDialog.setMessage("Please Wait While We Register You...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(Signup.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        progressDialog.dismiss();
                        Toast.makeText(Signup.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
    }

    private void sendUserToNextActivity() {
        Intent intent=new Intent(Signup.this,Parts.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}